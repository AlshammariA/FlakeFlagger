@Test public void should_pass_if_actual_file_has_the_given_file_name(){
  paths.assertHasFileName(info,existingFile,"gc.log");
}
