# this to run generate the processsed_data from the features collections


DATA_dir="dir_to_folder_of_collected_projects"
output_dir="dir_to_output_folder"
source_flakiness="dir_to_sources_of_flaky_tests.csv"

python3 generate_processed_data.py $DATA_dir $output_dir $source_flakiness

#python generate_processed_data.py $DATA_dir $output $source_flakiness
