# Test Flakiness Classification 

processed_data="result/processed_data_with_vocabulary_per_test.csv"
FlakeFlaggerFeatures="input_data/FlakeFlaggerFeaturesTypes.csv"
InformationGain="result/Information_gain_per_feature.csv"
main_processed_data="result/processed_data.csv"

python3 flakeflagger_predicter.py $processed_data $FlakeFlaggerFeatures $InformationGain $main_processed_data
