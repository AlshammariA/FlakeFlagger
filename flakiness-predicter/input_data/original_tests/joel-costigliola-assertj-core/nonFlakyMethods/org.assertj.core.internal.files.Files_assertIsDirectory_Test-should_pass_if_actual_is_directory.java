@Test public void should_pass_if_actual_is_directory(){
  when(actual.isDirectory()).thenReturn(true);
  files.assertIsDirectory(someInfo(),actual);
}
