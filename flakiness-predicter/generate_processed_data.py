#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Mar  4 16:25:54 2021

@authors: FlakeFlagger Authors .. 
"""


import pandas as pd
import numpy as np
import warnings
import os
import sys
from pathlib import Path
import time


#%%
def concatenate_csv_files(files,csvFileName,ouptut):

    merge_csv = pd.concat((pd.read_csv(m) for m in files), axis=0, ignore_index=True)    
    merge_csv.to_csv(ouptut+csvFileName+'.csv',  index=False)

#%%
def fix_empty_csvFiles(files,new_columns):
    fixed_csv_files = pd.DataFrame(columns = new_columns)
    for file in files:
        if (len(open(file).readlines()) == 0):
            fixed_csv_files.to_csv(file,  index=False)
   
#%%
def collect_flakeFlagger_files(clone_project,ouptut):
# to collect all csv files in result folder
    smellsPretty = []
    basicDemographics = []
    churn = []
    ExecutionTime = []
    LibrariesUsages = []
    
    #flags 
    smell_columns = True
    basicDemographics_columns = True
    churn_columns = True
    ExecutionTime_columns = True
    LibrariesUsages_columns = True
    
    print ("-- >  Start Collecting all csv files from each project to form processed_data.csv ")
    for root, dirs, files in os.walk(clone_project):
        for file in files:
            if file.endswith("smells-pretty.csv"):
                file_dir = os.path.join(root, file)
                smellsPretty.append(file_dir)
                if(smell_columns):
                    if (len(open(file_dir).readlines()) > 0):
                        smell_columns_lst = (pd.read_csv(file_dir)).columns
                        smell_columns = False

            elif file.endswith("basicDemographics.csv"):
                file_dir = os.path.join(root, file)
                basicDemographics.append(file_dir)
                if(basicDemographics_columns):
                    if (len(open(file_dir).readlines()) > 0):
                        basicDemographics_columns_lst = (pd.read_csv(file_dir)).columns
                        basicDemographics_columns = False


            elif file.endswith("churn.csv"):
                file_dir = os.path.join(root, file)
                churn.append(file_dir)
                if(churn_columns):
                    if (len(open(file_dir).readlines()) > 0):
                        churn_columns_lst = (pd.read_csv(file_dir)).columns
                        churn_columns = False

            elif file.endswith("ExecutionTime.csv"):
                file_dir = os.path.join(root, file)
                ExecutionTime.append(file_dir)
                if(ExecutionTime_columns):
                    if (len(open(file_dir).readlines()) > 0):
                        ExecutionTime_columns_lst = (pd.read_csv(file_dir)).columns
                        ExecutionTime_columns = False

            elif file.endswith("LibrariesUsages.csv"):
                file_dir = os.path.join(root, file)
                LibrariesUsages.append(file_dir)
                if(LibrariesUsages_columns):
                    if (len(open(file_dir).readlines()) > 0):
                        LibrariesUsages_columns_lst = (pd.read_csv(file_dir)).columns
                        LibrariesUsages_columns = False
    
    # fix if there is an empty csv file  
    fix_empty_csvFiles(smellsPretty,smell_columns_lst)
    fix_empty_csvFiles(basicDemographics,basicDemographics_columns_lst)
    fix_empty_csvFiles(churn,churn_columns_lst)
    fix_empty_csvFiles(ExecutionTime,ExecutionTime_columns_lst)
    fix_empty_csvFiles(LibrariesUsages,LibrariesUsages_columns_lst)
    
    concatenate_csv_files(smellsPretty,"All-smells",ouptut)
    concatenate_csv_files(basicDemographics,"All-basicDemographics",ouptut)
    concatenate_csv_files(churn,"All-churn",ouptut)
    concatenate_csv_files(ExecutionTime,"All-ExecutionTime",ouptut)
    concatenate_csv_files(LibrariesUsages,"All-LibrariesUsages",ouptut)

#%%
def generate_processed_data_for_flakiness_prediction(result_dir,flaky_test_list):

    print ("-- >  Start generating processed_data.csv ")

    # start with copying the All-smells.csv
    processed_data = pd.read_csv(result_dir+"All-smells.csv")
    processed_data["test_name"] = processed_data["testClassName"]+"."+processed_data["testMethodName"]
    for col in processed_data.columns:
        if col.startswith('Unnamed: '):
            processed_data = processed_data.drop([col], axis=1)
    
    # now we add the execution_time here .. 
    executionTime_data = pd.read_csv(result_dir+"All-ExecutionTime.csv")
    executionTime_data["test_name"] = executionTime_data["testClassName"]+"."+executionTime_data["testMethodName"]
    specific_df_columns = executionTime_data[["test_name","ExecutionTime"]]    
    processed_data_with_execution_time = pd.merge(processed_data, specific_df_columns,on="test_name",how="left")

    # now we add the demographic data .. 
    basicDemographics_data = pd.read_csv(result_dir+"All-basicDemographics.csv")
    basicDemographics_data["test_name"] = basicDemographics_data["testClassName"]+"."+basicDemographics_data["testMethodName"]
    specific_df_columns = basicDemographics_data[["test_name","testLength","numAsserts","numCoveredLines"]]    
    processed_data_with_basicDemographics = pd.merge(processed_data_with_execution_time, specific_df_columns,on="test_name",how="left")

    # now we add the churn data .. 
    churn_data = pd.read_csv(result_dir+"All-churn.csv")
    churn_data["test_name"] = churn_data["test"].str.replace("#",".")
    specific_df_columns = churn_data[["test_name","projectSourceLinesCovered","projectSourceClassesCovered",
                          "hIndexModificationsPerCoveredLine_window5",
                          "hIndexModificationsPerCoveredLine_window10",
                          "hIndexModificationsPerCoveredLine_window25",
                          "hIndexModificationsPerCoveredLine_window50",
                          "hIndexModificationsPerCoveredLine_window75",
                          "hIndexModificationsPerCoveredLine_window100",
                          "hIndexModificationsPerCoveredLine_window500",
                          "hIndexModificationsPerCoveredLine_window10000"]]    
    processed_data_with_churn = pd.merge(processed_data_with_basicDemographics, specific_df_columns,on="test_name",how="left")
    
    
    # now we add the num_third_party_libs ..
    library_domains = ["org.w3c", "java.", "javax.","com.sun","org.junit","junit.","org.easymock"]
    LibrariesUsages_data = pd.read_csv(result_dir+"All-LibrariesUsages.csv")

    LibrariesUsages_data["test_name"] = LibrariesUsages_data["testClassName"]+"."+LibrariesUsages_data["testMethodName"]
    LibrariesUsages_data = LibrariesUsages_data.drop_duplicates(keep = "first")
    LibrariesUsages_data["num_third_party_libs"] = 1
    for index, row in LibrariesUsages_data.iterrows():
        if str(row['libraryName']).startswith(tuple(library_domains)):
            LibrariesUsages_data.loc[index,'num_third_party_libs']=0
    
    LibrariesUsages_data = LibrariesUsages_data[["test_name","num_third_party_libs"]]
    specific_df_columns = LibrariesUsages_data.groupby(["test_name"]).num_third_party_libs.sum().reset_index()
    processed_data_with_libraries_usages = pd.merge(processed_data_with_churn, specific_df_columns,on="test_name",how="left")

    
    # now we need to reorder the test_name and flaky columns .. 
    test_name_col = processed_data_with_libraries_usages['test_name']
    processed_data_with_libraries_usages.drop(labels=['test_name'], axis=1,inplace = True)
    processed_data_with_libraries_usages.insert(3, 'test_name', test_name_col)
    
    # add the flakiness status to for each test_name
    processed_data_with_libraries_usages.insert(4, 'flaky', test_name_col)
    processed_data_with_libraries_usages['flaky'] = np.where(processed_data_with_libraries_usages['test_name'].isin(flaky_test_list), 1, 0) 
    
    # in case of duplication
    processed_data_with_libraries_usages = processed_data_with_libraries_usages.drop_duplicates(keep='first')
    processed_data_with_libraries_usages.to_csv(result_dir+"your_processed_data.csv",  index=False)
    
#%%
execution_time = time.time()

if __name__ == '__main__':
        
    # directory of projects that we collect flakgeflagger features. 
    clone_project = sys.argv[1]

    # output ... in case the folder does not exist
    ouptut = "result/"
    Path(ouptut).mkdir(parents=True, exist_ok=True)
    
    # collect all files in one folder ... 
    collect_flakeFlagger_files(clone_project,ouptut)
    
    # start generating the processed_data file. 
    flaky_test_list = pd.read_csv(sys.argv[2])[sys.argv[3]].unique()
    generate_processed_data_for_flakiness_prediction(ouptut,flaky_test_list)
    
    print("The process of generating processed_data.csv is completed in : (%s) seconds. " % round((time.time() - execution_time), 3))