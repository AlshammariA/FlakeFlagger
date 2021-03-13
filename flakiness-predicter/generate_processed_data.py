
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
    merge_csv.to_csv(ouptut+csvFileName,  index=False)


#%%
def check_broken_files(file):
    return (len(open(file).readlines()) > 0)

#%%
def collect_specific_dircs(main_dir,file_name):
    print ("-- >  Start collecting the directories of "+file_name+" result from each project ... ")
    directories = [x[0] for x in os.walk(main_dir) if x[0].endswith(file_name)]
    return directories

#%%
def collect_FlakeFlagger_files(clone_project,ouptut):
    
    # get all target directories .. 
    target_dirs = collect_specific_dircs(clone_project,"target")
    
    # ignored_files: this is when a file is broken and cannot be merge with the file result
    correct_files = []
    features_csv_files_lst = ["smells-pretty.csv","basicDemographics.csv","churn.csv","ExecutionTime.csv","LibrariesUsages.csv"]
    for target in target_dirs:
        for csv_file_type in features_csv_files_lst:
            if (csv_file_type == "smells-pretty.csv"):
                smell_file = target + "/"+csv_file_type
                if (os.path.exists(smell_file)):
                    if (check_broken_files(smell_file)):
                        correct_files.append(smell_file)
            else:
                target_file = target + "/demographic-reports/"+csv_file_type
                if (os.path.exists(target_file)):
                    if (check_broken_files(target_file)):
                        correct_files.append(target_file)
            

    # concatnate each specific types together    
    print ("-- >  Start merging all csv files ... ")
    for file_type in features_csv_files_lst:
        specific_lst = []
        for file in correct_files:
            if (file.endswith(file_type)):
                specific_lst.append(file)
        
        # concatenate the list
        concatenate_csv_files(specific_lst,"All-"+file_type,ouptut)
    
#%%
def generate_processed_data_for_flakiness_prediction(result_dir,flakySource):

    print ("-- >  Start generating processed_data.csv ")

    # start with copying the All-smells.csv
    processed_data = pd.read_csv(result_dir+"All-smells-pretty.csv")
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
    pattern = '|'.join(library_domains)
    
    LibrariesUsages_data['external_library'] = ~(LibrariesUsages_data.libraryName.str.contains(pattern))
    LibrariesUsages_data['external_library'] = LibrariesUsages_data['external_library'].astype(int)
    LibrariesUsages_data = LibrariesUsages_data[LibrariesUsages_data["external_library"] == 1]
    specific_df_columns = LibrariesUsages_data[["test_name"]]
    LibrariesUsages_data = specific_df_columns.groupby(["test_name"]).size().reset_index(name="num_third_party_libs")    
    processed_data_with_libraries_usages = pd.merge(processed_data_with_churn, LibrariesUsages_data,on="test_name",how="left")


    # now we need to label each tests with its status ( flaky or not flaky )
    processed_data_with_libraries_usages['flaky'] = np.where(processed_data_with_libraries_usages['test_name'].isin(flakySource.test_name.unique()), 1, 0)
    
    # now we need to reorder the test_name and flaky columns .. 
    test_name_col = processed_data_with_libraries_usages['test_name']
    processed_data_with_libraries_usages.drop(labels=['test_name'], axis=1,inplace = True)
    processed_data_with_libraries_usages.insert(3, 'test_name', test_name_col)    
    flaky_col = processed_data_with_libraries_usages['flaky']
    processed_data_with_libraries_usages.drop(labels=['flaky'], axis=1,inplace = True)
    processed_data_with_libraries_usages.insert(4, 'flaky', flaky_col)

    processed_data_with_libraries_usages.to_csv(result_dir+"processed_data.csv",  index=False)
    
#%%
execution_time = time.time()

if __name__ == '__main__':
        
    # directory of projects that we collect flakgeflagger features. 
    clone_project = sys.argv[1]

    # output ... in case the folder does not exist
    ouptut = sys.argv[2]
    Path(ouptut).mkdir(parents=True, exist_ok=True)
    
    # collect all files in one folder ... 
    collect_FlakeFlagger_files(clone_project,ouptut)
    
    
    # start generating the processed_data file. 
    flakySource = pd.read_csv(sys.argv[3])
    generate_processed_data_for_flakiness_prediction(ouptut,flakySource)
    
    print("The process of generating processed_data.csv is completed in : (%s) seconds. " % round((time.time() - execution_time), 3))
    