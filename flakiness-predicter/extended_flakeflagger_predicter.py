
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
import compute_information_gain as IG


#%%
def main_inspection(data,min_flaky):    
    
    if ('flaky_source' in data.columns):
        data = data.drop(['flaky_source'], axis=1)
    data = data.dropna()
    lst_project = IG.get_specific_project_data(data,min_flaky)
    new_data = data[data['project'].isin(lst_project)]
    unwanted_columns = ['Unnamed: 0', 'testClassName', 'testMethodName','flaky_source']
    for col in unwanted_columns:
        if (col in new_data.columns):
            new_data = new_data.drop([col], axis=1)
    
    return new_data

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
    
def generateConfusionMatrixByProject(data,processed_data):
    
    filter_data = data[['cross_validation', 'balance_type',"fold_size", 'IG_min', 'numTrees', 'classifier','features_structure']]
    filter_data = filter_data.drop_duplicates()
    df_columns = ['cross_validation', 'balance_type',"fold_size", 'IG_min', 'numTrees', 'classifier',"features_structure","project","TP","FN","FP","TN","Precision","Recall","F1"]    
    result = pd.DataFrame(columns = df_columns)
    
    # add project name to the full result .. 
    data_with_project_name = processed_data[['project','test_name']]
    updated_data = pd.merge(data,data_with_project_name,on='test_name',how='left')

    
    for index, row in filter_data.iterrows():
        data_per_result = updated_data[(updated_data['cross_validation'] == row['cross_validation']) &
                                      (updated_data['balance_type'] == row['balance_type']) &
                                      (updated_data['IG_min'] == row['IG_min']) &
                                      (updated_data['numTrees'] == row['numTrees']) &
                                      (updated_data['classifier'] == row['classifier']) &
                                      (updated_data['fold_size'] == row['fold_size']) &
                                      (updated_data['features_structure'] == row['features_structure']) ]

        for proj in data_per_result.project.unique():
                sepcific_project = data_per_result[data_per_result["project"] == proj]
                TP = FN = FP = 0 
                TP = len(sepcific_project[sepcific_project["Matrix_label"] == "TP"])
                FN = len(sepcific_project[sepcific_project["Matrix_label"] == "FN"])
                FP = len(sepcific_project[sepcific_project["Matrix_label"] == "FP"])
                TN = len(processed_data[processed_data["project"] == proj]) - (TP+FN+FP)
                accuracy, F1, Precision, Recall = get_scores(TN,FP,FN,TP)
                result = result.append(pd.Series([row['cross_validation'],row['balance_type'],row['fold_size'],row['IG_min'],row['numTrees'],row['classifier'],row['features_structure'],proj,TP, FN, FP, TN,str(round(((Precision)*100)))+"%", str(round(((Recall)*100)))+"%",str(round(((F1)*100)))+"%"], index=result.columns ), ignore_index=True)

    return result


#%%
def predict_crossValidation(data,k,foldType,balance,classifier,mintree,Features_type,ig,result_by_test_name):

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
        elif(balance == "undersampling"):
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

        final_model = model.fit(x_train, y_train)
        preds = final_model.predict(x_test)
        
        actual_status = y_test['flakyStatus'].tolist()
        for i in range (0,len(test_names_as_list)):
            if (actual_status[i] == 1 and  preds[i]== 1):
                result_by_test_name = result_by_test_name.append(pd.Series([foldType,balance,k,ig,mintree,classifier,Features_type,test_names_as_list[i],"TP"], index=result_by_test_name.columns ), ignore_index=True)
            elif (actual_status[i] == 1 and  preds[i]== 0):
                result_by_test_name = result_by_test_name.append(pd.Series([foldType,balance,k,ig,mintree,classifier,Features_type,test_names_as_list[i],"FN"], index=result_by_test_name.columns ), ignore_index=True)
            elif (actual_status[i] == 0 and  preds[i]== 1):
                result_by_test_name = result_by_test_name.append(pd.Series([foldType,balance,k,ig,mintree,classifier,Features_type,test_names_as_list[i],"FP"], index=result_by_test_name.columns ), ignore_index=True)
        
        tn, fp, fn, tp = confusion_matrix(y_test, preds, labels=[0,1]).ravel()
        TN = TN + tn
        FP = FP + fp
        FN = FN + fn
        TP = TP + tp
        
        # auc computation and others .. 
        false_positive_rate, true_positive_rate, thresholds = roc_curve(y_test, final_model.predict(x_test))
        auc_scores.append(auc(false_positive_rate, true_positive_rate))
    accuracy, F1, Precision, Recall = get_scores(TN,FP,FN,TP) 
    auc_scores = [0 if math.isnan(x) else x for x in auc_scores]
    return TN, FP, FN, TP, round((Precision*100)), round(((Recall)*100)), round((F1*100)), round(((sum(auc_scores)/k)*100)),result_by_test_name
    

#%%
def predict_external_dataset(data,test_data,k,foldType,balance,classifier,mintree,Features_type,ig,result_by_test_name):

    data = data.dropna()
    test_data = test_data.dropna()
    if "project_y" in data.columns:
        del data["project_y"]
    if "project" in data.columns:
        del data["project"]

    if "project_y" in test_data.columns:
        del test_data["project_y"]
    if "project" in test_data.columns:
        del test_data["project"]

    y_train = data[['flakyStatus']]
    x_train = data.drop(['flakyStatus'], axis=1)
    y_test = test_data[['flakyStatus']]
    x_test = test_data.drop(['flakyStatus'], axis=1)
    
    
    auc_scores = []
    TN = FP = FN = TP = 0
        
    test_names_as_list = x_test['test_name'].tolist()
    x_train = x_train.drop(columns='test_name')
    x_test = x_test.drop(columns='test_name')
    
    if(balance == "SMOTE"):
        oversample = SMOTE()
        x_train, y_train = oversample.fit_resample(x_train, y_train)
    elif(balance == "undersampling"):
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

    final_model = model.fit(x_train, y_train)
    preds = final_model.predict(x_test)
    
    actual_status = y_test['flakyStatus'].tolist()
    for i in range (0,len(test_names_as_list)):
        if (actual_status[i] == 1 and  preds[i]== 1):
            result_by_test_name = result_by_test_name.append(pd.Series(["external_test_data",balance,k,ig,mintree,classifier,Features_type,test_names_as_list[i],"TP"], index=result_by_test_name.columns ), ignore_index=True)
        elif (actual_status[i] == 1 and  preds[i]== 0):
            result_by_test_name = result_by_test_name.append(pd.Series(["external_test_data",balance,k,ig,mintree,classifier,Features_type,test_names_as_list[i],"FN"], index=result_by_test_name.columns ), ignore_index=True)
        elif (actual_status[i] == 0 and  preds[i]== 1):
            result_by_test_name = result_by_test_name.append(pd.Series(["external_test_data",balance,k,ig,mintree,classifier,Features_type,test_names_as_list[i],"FP"], index=result_by_test_name.columns ), ignore_index=True)
    
    tn, fp, fn, tp = confusion_matrix(y_test, preds, labels=[0,1]).ravel()
    TN = TN + tn
    FP = FP + fp
    FN = FN + fn
    TP = TP + tp
    
    # auc computation and others .. 
    false_positive_rate, true_positive_rate, thresholds = roc_curve(y_test, final_model.predict(x_test))
    auc_scores.append(auc(false_positive_rate, true_positive_rate))
    accuracy, F1, Precision, Recall = get_scores(TN,FP,FN,TP) 
    auc_scores = [0 if math.isnan(x) else x for x in auc_scores]
    return TN, FP, FN, TP, round((Precision*100)), round(((Recall)*100)), round((F1*100)), round(((sum(auc_scores)/k)*100)),result_by_test_name


#%%
def prepare_external_data(data):
    #drop unwanted columns 
    unwanted_columns = ['Unnamed: 0', 'testClassName', 'testMethodName','flaky_source']
    for col in unwanted_columns:
        if (col in data.columns):
            data = data.drop([col], axis=1)
    if ("flaky" in data.columns):
        data = data.rename(columns={'flaky': 'flakyStatus'})
    
    return data

#%%   
execution_time = time.time()
#command : 
    
if __name__ == '__main__':
    warnings.simplefilter("ignore")

    # processed data - training data
    main_data = pd.read_csv(sys.argv[1])  
    main_data = main_inspection(main_data,1)
    if ("flaky" in main_data.columns):
        main_data = main_data.rename(columns={'flaky': 'flakyStatus'})

    # for testing data .. ( if argv 1 == argv 2 -- cross validation .. otherwise, it is an external dataset .. )
    main_test_data = pd.read_csv(sys.argv[2])
    cross_validation = True
    if (sys.argv[2] != sys.argv[1]):
        cross_validation = False
        main_test_data = prepare_external_data(main_test_data)
        output_dir = sys.argv[3]+"/result/only_flakeflagger_classification_result/using_external_testing_dataset/"
        Path(output_dir).mkdir(parents=True, exist_ok=True)    
        
    else:
        output_dir = sys.argv[3]+"/result/only_flakeflagger_classification_result/using_cross_validation/"
        Path(output_dir).mkdir(parents=True, exist_ok=True)    


    #collect IG per feature
    IG_flag = True
    if (IG_flag):
        IG_result = pd.DataFrame(columns = ['features','type','IG'])    
        unwantedColumns = ['test_name', 'flakyStatus', 'project']
        print ("=========================================================")
        IG_lst = IG.calculateOnlyFlakeFlaggerIG(main_data,unwantedColumns,IG_result)
        IG_lst.to_csv(output_dir+'FlakeFlagger_features_IGs.csv',  index=False)   
        print ("=========================================================")
        
    else:
        # pass the IG csv file .. 
        IG_lst = pd.read_csv(output_dir+'FlakeFlagger_features_IGs.csv')

    ##=========================================================##
    # arguments
    kfold = [5,10] # number of folds
    fold_type = ["StratifiedKFold"]
    balance = ["SMOTE"] # ['SMOTE', 'undersampling', 'none']
    classifier = ['RF'] # ['RF', 'SVM', 'DT', 'MLP', 'NB', 'KNN']
    treeSize = [1000] # it could be between 100 to 5000 
    minIGList = [0] # it could be any value between 0 and 1
    
    IG_flag = True # this flag should be false if there is no feature reach the min IG
    ##=========================================================##
    # this is for output dataframes .. 
    result_by_test_name_columns = ["cross_validation","balance_type","fold_size","IG_min","numTrees","classifier","features_structure","test_name","Matrix_label"]    
    df_columns = ["Model","cross_validation","fold_size","balance_type","numTrees","features_structure","IG_min","num_satsifiedFeatures","classifier","TP","FN","FP","TN","precision","recall","F1_score","AUC"]    

    for ig in minIGList:
        # create IG subfolder 
        Path(output_dir+"IG_"+str(ig)).mkdir(parents=True, exist_ok=True)
        min_IG = IG_lst[IG_lst["IG"]>=ig]
        keep_minIG = min_IG.features.unique()
        keep_minIG = [x for x in keep_minIG if str(x) != 'nan']


        processed_data = main_data.copy()
        if (not cross_validation):
            test_processed_data = main_test_data.copy()
        
        if(ig != 0):
            keep_columns = keep_minIG + ['project','flakyStatus','test_name']
            if (len(keep_minIG) == 0):
                IG_flag = False
            processed_data = processed_data[keep_columns]
            if (not cross_validation):
                test_processed_data = test_processed_data[keep_columns]


        result = pd.DataFrame(columns = df_columns)
        result_by_test_name = pd.DataFrame(columns = result_by_test_name_columns)
        
        if (IG_flag):
            for mintree in treeSize:
                for fold in fold_type:
                    for bal in balance:
                        for cl in classifier:
                            for k in kfold:
    
                                # print the given variables for easy debug. 
                                print ("==> run selection is: (information_gain>="+str(ig)+")+(Classifier="+cl+")+(Balance="+bal+")+(Fold type="+fold+")+(Minimum tress [RF only]="+str(mintree)+")+(fold_size="+str(k)+")")
                                if (cross_validation):
                                    TN, FP, FN, TP, Precision, Recall, f1, auc_score,result_by_test_name  = predict_crossValidation(processed_data,k,fold,bal,cl,mintree,"Flake-Flagger-Features",ig,result_by_test_name)
                                    result = result.append(pd.Series(["CrossAllProjects",fold,k,bal,mintree,"Flake-Flagger-Features",ig,processed_data.shape[1]-1,cl,TP, FN, FP, TN, Precision, Recall, f1,auc_score], index=result.columns ), ignore_index=True)                
                                    print ("--> The prediction based on the FlakeFlagger features is completed ")
                                    print("=======================================================================")
                                else:
                                    TN, FP, FN, TP, Precision, Recall, f1, auc_score,result_by_test_name  = predict_external_dataset(processed_data,test_processed_data,k,fold,bal,cl,mintree,"Flake-Flagger-Features",ig,result_by_test_name)
                                    result = result.append(pd.Series(["CrossAllProjects","external_test_data",k,bal,mintree,"Flake-Flagger-Features",ig,test_processed_data.shape[1]-1,cl,TP, FN, FP, TN, Precision, Recall, f1,auc_score], index=result.columns ), ignore_index=True)                
                                    print ("--> The prediction based on the FlakeFlagger features is completed ")
                                    print("=======================================================================")
    
            result_by_test_name.to_csv(output_dir+"IG_"+str(ig)+'/prediction_result_per_test.csv',  index=False)        
            result.to_csv(output_dir+"IG_"+str(ig)+'/prediction_result.csv',  index=False)
            
            # Here we want to generate the confusion matrix by project...
            if (cross_validation):
                confusion_matrix_by_project = generateConfusionMatrixByProject(result_by_test_name,processed_data)
            else:
                confusion_matrix_by_project = generateConfusionMatrixByProject(result_by_test_name,test_processed_data)
                
            confusion_matrix_by_project.to_csv(output_dir+"IG_"+str(ig)+'/prediction_result_by_project.csv',  index=False)        
        else:
            print ("--> Warning: No FlakeFlagger feature' IG larger than the given min IG ")
      
    print("The process is completed in : (%s) seconds. " % round((time.time() - execution_time), 5))