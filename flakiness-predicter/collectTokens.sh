# this to extend the given processed_data to have token/vocabs list per test.

dir="input_data/original_tests/"
processed_data="result/processed_data.csv"
output='result/processed_data_with_vocabulary_per_test_for_one_project'


python3 collect_vocabs_per_test.py $dir $processed_data $output
