@Test public void should_pass_if_actual_directory_has_the_given_file_name(){
  paths.assertHasFileName(info,existingDirectory,"dir2");
}
