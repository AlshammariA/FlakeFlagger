@Test public void should_pass_if_actual_non_existent_path_has_the_given_file_name(){
  paths.assertHasFileName(info,nonExistingPath,"fake.log");
}
