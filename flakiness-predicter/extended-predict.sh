# FlakeFlagger Classification Setup

# original FlakeFlagger dataset is "result/processed_data.csv"
training_data="result/processed_data.csv"

testing_data="result/your-testing-dataset.csv"

output_dir="extended_FlakeFlagger_result/FlakeFlagger-prediction-on-your-dataset"



# boolean arguments
cross_validation=True
IG_flag=True # True if you want to re-calculate the IG for FlakeFlagger features (in case you train on another dataset). 
train_model=True
min_IG_flag=True




# short list of FlakeFlagger arguments 
export fold_type=("StratifiedKFold")

# full list ==> balance=("SMOTE" "undersampling" "none")
export balance=("SMOTE")

# full list ==> classifier=("RF" "NB" "SVM" "DT" "MLP" "KNN")
export classifier=("RF")

# full list ==> treeSize=(500 1000) for random forest only .. 
export treeSize=(100) # The default number of tree in Random Forest is 100 

# full list ==> it should be at least in the range of IG which is (0-1)
export minIGList=(0.0) #(0.0 means that we use all features)

# full list ==> In case of not cross validation (testing data differs from training) ( kfold=(1))
export kfold=(1)



python extended_flakeflagger_predicter.py $training_data $testing_data $output_dir $cross_validation $IG_flag $min_IG_flag $train_model "${fold_type[*]}" "${balance[@]}" "${classifier[*]}" "${treeSize[*]}" "${minIGList[*]}" "${kfold[*]}"
