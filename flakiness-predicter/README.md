# FlakeFlagger

This is a simple guideline to use/replicate our experiment of FlakeFlagger.   

## Requirements
This is a list of all required python package requirements:
- Python >=3.6
- imbalanced_learn >= 0.6.2
- numpy >= 1.18.1
- pandas >= 1.0.1
- scikit_learn >= 0.22.1


## Input Files:
1. data/full_data.csv: 
	This contains our collected data. Each row contains test name, its flaky status, list of its tokens, FlakeFlagger features results
2. token_by_IG/IG_MSR_and_FlakeFlagger_features.csv:
	This contains all features that have at least 0.0001 Information gain. Some token have zero as we round the IG value up. 

## How to replicate our experiment?

- To compute the IG for all token (it takes hours because there are more than 30k tokens) you can run the following command:
```console
Python3 IG_computation_for_crossAllProjects.py input_data/data/full_data.csv input_data/processed_data.csv
```

The output will replace the file (token_by_IG/IG_MSR_and_FlakeFlagger_features.csv).


- To run the model again on the same data and replicate our result, use the following command:
 ```console
python3 cross-all-projects-model-MSR.py input_data/data/full_data.csv input_data/FlakeFlaggerFeaturesTypes.csv token_by_IG/IG_MSR_and_FlakeFlagger_features.csv 
```

Note: We used minimum IG = 0.01, StratifiedKFold, Random Forest, 5000 as minimum number of trees,SMOTE as a balance technique, and 10% as split size. You can change:
1. RF to SVM, DT, MLP, NB or KNN
2. StratifiedKFold to KFold
3. SMOTE to none (to see the result without balancing)
4. Any number of trees, IG, or split size

The output will be under result/crossAllProjects/ folder and it has two files:
1 summary classifications: showing the confusion matrix, F1 score, precision, recall, AUC for three models: Our approach, Pinto et al. approach, and the combination of two models. 
2. list of all False positive, False negative, and True positive, foreach model.  



- To show the result (by projects, as Table 3 in the paper), you can run this command after you get the classification result 

 ```console
python confusion-matrix-by-test-name.py input_data/processed_data.csv result/crossAllProjects/RF/cross_all_projects_result_by_test_IG0.01.csv input_data/data/full_data.csv
```
The output will be in result/ConfusionMatrixByModel/
