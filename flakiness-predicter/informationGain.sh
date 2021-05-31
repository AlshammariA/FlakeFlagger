# this to run generate information gain for given processsed_data

DATA="result/processed_data_with_vocabulary_per_test.csv"
output="result/Information_gain_per_feature"


python compute_information_gain.py $DATA $output
