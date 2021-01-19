
import io 
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize 
import string
from string import punctuation
import os
import sys
from pathlib import Path
import re
import time
import pandas as pd
import numpy as np
import warnings
from sklearn.feature_extraction.text import CountVectorizer

#%%
def convert_to_txt(folder):
    for file in os.listdir(folder):
       java_file = os.path.join(folder,file)
       txt_file = java_file.replace('.java', '.txt')
       os.rename(java_file, txt_file)

#%%
def get_test_contents_and_header_without_comments(test_content):
    
    # exclude the header of a test .. 
    test_header = str(test_content.split('{')[0])
    test_header = str(test_header.split('*/')[-1])
    only_test_body = test_content.split(test_header,1)[1]
    allowed_punctuation = ['_','-']
    for p in string.punctuation:
        if (p not in allowed_punctuation):
            only_test_body = only_test_body.replace(p, " ")
    return only_test_body,test_header


#%%
def remove_stop_words(test_content,test_header):   
    # used to get only timeout=XXX words .. 

    stop_words_lst = set(stopwords.words('english'))
    test_words = word_tokenize(test_content) 
    header_Words = word_tokenize(test_header)
    remaining_words = [] 
    # read each word and remove stop words and string punctuations ..    
    for i in test_words: 
        if i not in stop_words_lst and i not in string.punctuation:
            remaining_words.append(i) 

    # add header words here as well 
    for j in header_Words: 
        if j not in stop_words_lst and j not in string.punctuation:
            remaining_words.append(j) 
    
    # remove numbers ..
    remaining_words_filtered = [i for i in remaining_words if not i.isdigit()]
    remaining_words_filtered = [i.rstrip(string.digits) for i in remaining_words_filtered]
    final_list = [i.rstrip(string.punctuation) for i in remaining_words_filtered]
    
    
    return final_list


#%%
def detectCamelCaseWords(data):

    for i in data:
        if ("_" in i):
            j = str(i).replace('_',' ')
            lst_j = j.split(' ')
            for s in lst_j:
                data.append(s)
            data.remove(i)
    
    new_data = []
    for i in data:
        if (i.isupper()):
            i = i.lower()    
        words = re.findall('[A-Za-z][^A-Z]*', i)
        for w in words:
            new_data.append(w.lower())
        new_data.append(i.lower())
    
    return list(set(new_data))


#%%
def filterJavaList(words,java_keywords):
    nonJavaWords = []
    for w in words:
        if w not in java_keywords:
            nonJavaWords.append(w)
                
    return nonJavaWords

#%%
def detectJavaKeyword(test_content,test_header,java_keywords):
    java_words_per_test = []
    
    # from tests contents only
    test_words = word_tokenize(test_content) 
    for i in test_words: 
        if i in java_keywords:
            java_words_per_test.append(i) 

    # fro header only
    header_Words = word_tokenize(test_header)
    for i in header_Words: 
        if i in java_keywords:
            java_words_per_test.append(i)     
    
    return java_words_per_test
    

#%%
def fixTestNames(testname):
    if (".txt_" in testname):
        testname = testname.replace('.txt_','.java_')
    testname = testname.replace('.txt','')
    testname = testname.replace('-','.')
    testname = testname.lower()
    return testname
 
def JavaKeysAnalysis(data,java_keywords):
    
    # to convert javakeywords to matrix ... 
    columns_keywords = java_keywords
    columns_keywords=['null' if x is np.nan else x for x in columns_keywords]

    vectorizer = CountVectorizer(vocabulary=columns_keywords)
    javaKey_matrix = []
    
    # count freq for each java keywords 
    for i in data.java_keywords:
        per_lst = []
        per_lst.append(i)
        X = vectorizer.fit_transform(i)
        for j in sum(X.toarray()):
            per_lst.append(j)
        javaKey_matrix.append(per_lst)

    # convert matrix to dataframe
    matrix_result_df = pd.DataFrame.from_records(javaKey_matrix)
    columns = []
    columns.append("Java_keywords")
    for col in columns_keywords:
        columns.append(col)
    matrix_result_df.columns = columns

    # concatenate two dataframe .. 
    full_df_format = pd.concat([basic_df, matrix_result_df.reindex(basic_df.index)], axis=1)
    return full_df_format

#%%

def fixColumns(merge_data):
    # column should be in camel case to avoid duplicate columns .. 
    del merge_data ['Java_keywords']   
    nonJava_keys_columns = ['test_name', 'flakyStatus', 'tokenList', 'java_keywords', 'javaKeysCounter','testLength']

    for i in merge_data.columns:
        if i not in nonJava_keys_columns:
            merge_data.rename(columns = {i:i+'_keyword'}, inplace = True)
        
    return merge_data

#%%    
execution_time = time.time()


if __name__ == '__main__':

    path = sys.argv[1]
    project_paths = [f.path for f in os.scandir(path) if f.is_dir()]
    flaky_status = ['flakyMethods','nonFlakyMethods']
    out_path = 'result/'
    
    # just clean DS_store files .. 
    os.system('find . -name ".DS_Store" -delete')
 
    # get list of java key words.. 
    java_keywords = ['abstract', 'assert', 'boolean', 'break', 'byte', 'case', 'catch', 'char', 'class', 'continue', 'default', 'do', 'double', 'else', 'enum', 'exports', 'extends', 'final', 'finally', 'float', 'for', 'if', 'implements', 'import', 'instanceof', 'int', 'interface', 'long', 'modules', 'native', 'new', 'package', 'private', 'protected', 'public', 'requires', 'return', 'short', 'static', 'strictfp', 'super', 'switch', 'synchronized', 'this', 'throw', 'throws', 'transient', 'try', 'void', 'volatile', 'while', 'true', "null", 'false', 'const', 'goto']
    
    #Get the processed_data to merge with vocabulary_based_approach. 
    processed_data = pd.read_csv(sys.argv[2])
    
    # convert from java file to txt ... 
    for project in project_paths:
        for f in flaky_status:
            convert_to_txt(project+"/"+f+"/")
    
    # convert each test to a list of words ...
    print ("********* Start collecting words from each test .. ")
    df_columns = ["test_name","flakyStatus","tokenList","java_keywords","javaKeysCounter"]
    basic_df = pd.DataFrame(columns = df_columns)
    for project in project_paths:
        for f in flaky_status:
            folder = project+'/'+f
            project_name = os.path.basename(os.path.normpath(project))
            
            print ("********* Start processing project --> "+str(project_name) +" -- Type of Tests --> "+str(f))
            for filename in os.listdir(folder):
                file_name = os.path.join(folder,filename)
                test_name = open(file_name)
                test_words = test_name.read()

                if (test_words == ""):
                    print ("-->Skip ("+filename+") in "+project_name+" ("+f+ ") because it is empty")
                else:
                    test_content,test_header = get_test_contents_and_header_without_comments(test_words)
                    words_per_test = remove_stop_words(test_content,test_header)
                    final_list_nonJavaWords = filterJavaList(words_per_test,java_keywords)
                    final_list_words = detectCamelCaseWords(final_list_nonJavaWords)

                    # remove letters only ...
                    final_list_words = [i for i in final_list_words if i not in string.ascii_lowercase]
                    testname_lowerCase = fixTestNames(filename)
                    
                    #get javawords with duplication
                    java_words_per_test = detectJavaKeyword(test_content,test_header,java_keywords)
                                       
                    if (f == "flakyMethods"):
                        basic_df = basic_df.append(pd.Series([testname_lowerCase,1,final_list_words,java_words_per_test,len(java_words_per_test)], index=basic_df.columns ), ignore_index=True)
                    else:
                        basic_df = basic_df.append(pd.Series([testname_lowerCase,0,final_list_words,java_words_per_test,len(java_words_per_test)], index=basic_df.columns ), ignore_index=True)
        
    # now we extend the dataframe to include javaKeys matrix .. 
    result = JavaKeysAnalysis(basic_df,java_keywords)   
 
    # # fixing columns names  ..
    merge_data = fixColumns(result)
    
    # merge the processed data
    merge_result_with_processed_data = pd.merge(merge_data, processed_data, how='inner', on=['test_name'])       
    
    #Some columns are deleted .. 
    merge_result_with_processed_data = merge_result_with_processed_data.drop(['Unnamed: 0', 'testClassName', 'testMethodName','project','flaky'], axis=1)    
    merge_result_with_processed_data.to_csv(out_path+'processed_data_with_vocabulary_per_test.csv',  index=False)
        
    
print("The processed of collecting tokens per test in given projects is completed in : (%s) seconds. " % round((time.time() - execution_time), 5))