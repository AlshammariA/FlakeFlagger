@Test public void should_pass_if_actual_symbolic_link_has_the_given_file_name() throws IOException {
  paths.assertHasFileName(info,symlinkToNonExistingPath,"bad-symlink");
  paths.assertHasFileName(info,symlinkToExistingFile,"good-symlink");
}
