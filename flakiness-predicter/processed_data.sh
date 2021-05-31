# this to run generate the processsed_data from the features collections


projects_dir="dir_to_folder_of_collected_projects"
source_of_flaky_tests="FlakeList.csv"
column_name="test_name"

python generate_processed_data.py $projects_dir $source_of_flaky_tests $column_name
