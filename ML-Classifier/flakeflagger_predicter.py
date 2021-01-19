
import io 
import time
import pandas as pd
import warnings
import numpy as np
import os
import sys
from pathlib import Path
import ast
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.metrics import classification_report, f1_score, precision_score,recall_score, confusion_matrix
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
from sklearn.model_selection import KFold, StratifiedKFold
import warnings
from imblearn.over_sampling import SMOTE
from imblearn.under_sampling import RandomUnderSampler
from sklearn.metrics import roc_curve, auc, roc_auc_score
from sklearn import svm, tree
import math
from sklearn.tree import DecisionTreeClassifier
from sklearn import svm
from sklearn.ensemble import AdaBoostClassifier
from sklearn.naive_bayes import GaussianNB
from sklearn.neural_network import MLPClassifier
from sklearn.neighbors import KNeighborsClassifier



#%%
    
def get_scores (tn,fp,fn,tp):
    if(tp==0):
        accuracy = (tp+tn)/(tn+fp+fn+tp)
        Precision = 0
        Recall = 0
        F1 = 0    
    else:
        accuracy = (tp+tn)/(tn+fp+fn+tp)
        Precision = tp/(tp+fp)
        Recall = tp/(tp+fn)
        F1 = 2*((Precision*Recall)/(Precision+Recall))    
    return accuracy, F1, Precision, Recall

#%%
def predict_RF_crossValidation(data,k,foldType,balance,classifier,mintree,Features_type,ig,result_by_test_name):

    data = data.dropna()
    if "project_y" in data.columns:
        del data["project_y"]
    if "project" in data.columns:
        del data["project"]
    data_target = data[['flakyStatus']]
    data = data.drop(['flakyStatus'], axis=1)
    
    
    # KFold Cross Validation approaches
    if (foldType == "KFold"):
        fold = KFold(n_splits=k,shuffle=True)
    else:
        fold = StratifiedKFold(n_splits=k,shuffle=True)
    
    auc_scores = []
    TN = FP = FN = TP = 0
    for train_index, test_index in fold.split(data,data_target):
        x_train, x_test = data.iloc[list(train_index)], data.iloc[list(test_index)]
        y_train, y_test = data_target.iloc[list(train_index)], data_target.iloc[list(test_index)]
        
        test_names_as_list = x_test['test_name'].tolist()
        x_train = x_train.drop(columns='test_name')
        x_test = x_test.drop(columns='test_name')
        
        if(balance == "SMOTE"):
            oversample = SMOTE()
            x_train, y_train = oversample.fit_resample(x_train, y_train)
        elif(balance == "under"):
            undersampling = RandomUnderSampler()
            x_train, y_train = undersampling.fit_resample(x_train, y_train)
        
        if (classifier == 'DT'):
            model = DecisionTreeClassifier(criterion='entropy', max_depth = None)
        elif (classifier == 'RF'):
             model = RandomForestClassifier(criterion = "entropy",n_estimators=mintree)
        elif (classifier == 'MLP'):
            model = MLPClassifier(hidden_layer_sizes=(13,13,13),max_iter=50)        
        elif (classifier == 'SVM'):
            model = svm.SVC(gamma='scale')       
        elif (classifier == 'Ada'):
            model = AdaBoostClassifier(n_estimators=100, random_state=0) 
        elif (classifier == 'NB'):
            model = GaussianNB() 
        elif (classifier == 'KNN'):
            model = KNeighborsClassifier(n_neighbors=7)

        model = model.fit(x_train, y_train)
        preds = model.predict(x_test)
        
        actual_status = y_test['flakyStatus'].tolist()
        for i in range (0,len(test_names_as_list)):
            if (actual_status[i] == 1 and  preds[i]== 1):
                result_by_test_name = result_by_test_name.append(pd.Series([ig,mintree,Features_type,test_names_as_list[i],"TP"], index=result_by_test_name.columns ), ignore_index=True)
            elif (actual_status[i] == 1 and  preds[i]== 0):
                result_by_test_name = result_by_test_name.append(pd.Series([ig,mintree,Features_type,test_names_as_list[i],"FN"], index=result_by_test_name.columns ), ignore_index=True)
            elif (actual_status[i] == 0 and  preds[i]== 1):
                result_by_test_name = result_by_test_name.append(pd.Series([ig,mintree,Features_type,test_names_as_list[i],"FP"], index=result_by_test_name.columns ), ignore_index=True)
        
        tn, fp, fn, tp = confusion_matrix(y_test, preds, labels=[0,1]).ravel()
        TN = TN + tn
        FP = FP + fp
        FN = FN + fn
        TP = TP + tp
        
        # auc computation and others .. 
        false_positive_rate, true_positive_rate, thresholds = roc_curve(y_test, model.predict(x_test))
        auc_scores.append(auc(false_positive_rate, true_positive_rate))
    accuracy, F1, Precision, Recall = get_scores(TN,FP,FN,TP) 
    auc_scores = [0 if math.isnan(x) else x for x in auc_scores]
    return TN, FP, FN, TP, round((Precision*100)), round(((Recall)*100)), round((F1*100)), round(((sum(auc_scores)/k)*100)),result_by_test_name
    

#%%
def get_only_specific_columns_V1(full_data,specificColumns,wanted_columns):
    copy_fullData = full_data.copy()
    lst = []
    for i in specificColumns:
        lst.append(i)
    for j in wanted_columns:
        lst.append(j)
    available_columns =  list(set(lst) & set(full_data.columns))
    copy_fullData = copy_fullData[available_columns]   
    return copy_fullData
#%%
def get_only_specific_columns_V2(full_data,removed_specificColumns,removed_columns):
    copy_fullData = full_data.copy()
    lst = []
    for i in removed_specificColumns:
        lst.append(i)
    for j in removed_columns:
        lst.append(j)
    available_columns =  list(set(lst) & set(copy_fullData.columns))
    copy_fullData = copy_fullData.drop(columns=available_columns)
    return copy_fullData

#%%
def get_only_specific_columns_V3(full_data,removed_columns):
    copy_fullData = full_data.copy()
    lst = []
    for j in removed_columns:
        lst.append(j)
    available_columns =  list(set(lst) & set(copy_fullData.columns))
    copy_fullData = copy_fullData.drop(columns=available_columns)
    return copy_fullData
    
#%%
def vexctorizeToken(token):
    
    vocabulary_vectorizer = CountVectorizer()
    bow_train = vocabulary_vectorizer.fit_transform(token)
    matrix_token = pd.DataFrame(bow_train.toarray(), columns = vocabulary_vectorizer.get_feature_names())
    
    return matrix_token


#%%   
execution_time = time.time()
#command : python3 cross-all-projects-model-vocabulary.py input_data/data/full_data.csv input_data/FlakeFlaggerFeaturesTypes.csv token_by_IG/IG_vocabulary_and_FlakeFlagger_features.csv

if __name__ == '__main__':
    warnings.simplefilter("ignore")
    
    # vocabulary data _ processed data
    main_data = pd.read_csv(sys.argv[1])  
    
    # name of FlakeFlaggerFeatures .. 
    FlakeFlaggerFeatures = pd.read_csv(sys.argv[2])
    
    # IG per token/FlakeFlagger/JavaKeyWords
    IG_lst = pd.read_csv(sys.argv[3])
    
    
    output_dir = "result/classification_result/"
    Path(output_dir).mkdir(parents=True, exist_ok=True)    

    result_by_test_name_columns = ["IG_min","numTrees","features_structure","test_name","Matrix_label"]    
    df_columns = ["Model","cross_validation","balance_type","numTrees","features_structure","IG_min","num_satsifiedFeatures","classifier","TP","FN","FP","TN","precision","recall","F1_score","AUC"]    
        
    tokenOnly = vexctorizeToken(main_data['tokenList'])
    main_data = main_data.drop(columns=['tokenList'])
    vocabulary_processed_data = pd.concat([main_data, tokenOnly.reindex(main_data.index)], axis=1)
    
    minIGList = [0.02]
    for ig in minIGList:
        print ("start with min IG " + str(ig))
        min_IG = IG_lst[IG_lst["IG"]>=ig]
        keep_minIG = min_IG.features.unique()
        keep_minIG = [x for x in keep_minIG if str(x) != 'nan']
        removed_columns = ['java_keywords','javaKeysCounter']
    
        # shrink data now before classification for fast result ..
        vocabulary_processed_data_full = vocabulary_processed_data.copy()
        if(ig != 0):
            keep_columns = keep_minIG + ['flakyStatus','test_name']
            vocabulary_processed_data_full = vocabulary_processed_data_full[keep_columns]
        
        
        # arguments
        k = 5
        fold_type = ["StratifiedKFold"]
        balance = ["SMOTE"]
        #classifier = ["RF","SVM", "DT", "MLP", "NB", "KNN"]
        classifier = ["RF"]
        treeSize = [100]
        result = pd.DataFrame(columns = df_columns)
        result_by_test_name = pd.DataFrame(columns = result_by_test_name_columns)
        for mintree in treeSize:
            for fold in fold_type:
                for bal in balance:
                    for cl in classifier:
                        
                        # get only FlakeFlagger features ..
                        only_processed_data = get_only_specific_columns_V1(vocabulary_processed_data_full,FlakeFlaggerFeatures.allFeatures.unique(),["flakyStatus","test_name"])   
                        TN, FP, FN, TP, Precision, Recall, f1, auc_score,result_by_test_name  = predict_RF_crossValidation(only_processed_data,k,fold,bal,cl,mintree,"Flake-Flagger-Features",ig,result_by_test_name)
                        result = result.append(pd.Series(["CrossAllProjects",fold,bal,mintree,"Flake-Flagger-Features",ig,only_processed_data.shape[1]-1,cl,TP, FN, FP, TN, Precision, Recall, f1,auc_score], index=result.columns ), ignore_index=True)                
                        print ("Done from onlyFlakeFlaggerFeatures ... ")
                        
                        # get only vocabulary features ..
                        only_vocabulary_data = get_only_specific_columns_V2(vocabulary_processed_data_full,FlakeFlaggerFeatures.allFeatures.unique(),removed_columns)               
                        TN, FP, FN, TP, Precision, Recall, f1, auc_score,result_by_test_name  = predict_RF_crossValidation(only_vocabulary_data,k,fold,bal,cl,mintree,"vocabulary-Features",ig,result_by_test_name)
                        result = result.append(pd.Series(["CrossAllProjects",fold,bal,mintree,"vocabulary-Features",ig,only_vocabulary_data.shape[1]-1,cl,TP, FN, FP, TN, Precision, Recall, f1,auc_score], index=result.columns ), ignore_index=True)                
                        print ("Done from only Vocabulary ... ")
                        
                        # get only vocabulary features ..
                        only_vocabulary_data_withFlakeFlagger = get_only_specific_columns_V3(vocabulary_processed_data_full,removed_columns)
                        TN, FP, FN, TP, Precision, Recall, f1, auc_score,result_by_test_name  = predict_RF_crossValidation(only_vocabulary_data_withFlakeFlagger,k,fold,bal,cl,mintree,"vocabulary-with-flakeFlagger",ig,result_by_test_name)
                        result = result.append(pd.Series(["CrossAllProjects",fold,bal,mintree,"vocabulary-with-flakeFlagger",ig,only_vocabulary_data_withFlakeFlagger.shape[1]-1,cl,TP, FN, FP, TN, Precision, Recall, f1,auc_score], index=result.columns ), ignore_index=True)                
                        print ("Done from vocabulary-and-FlakeFlagger ... ")
                        
                        print (mintree,fold,bal,cl)
                        print("=======================================================================")
        result_by_test_name.to_csv(output_dir+'cross_all_projects_result_by_test_IG'+str(mintree)+'.csv',  index=False)        
        result.to_csv(output_dir+'cross_all_projects_IG'+str(mintree)+'.csv',  index=False)
        
print("The processed is completed in : (%s) seconds. " % round((time.time() - execution_time), 5))