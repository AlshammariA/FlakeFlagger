@Test public void should_pass_if_actual_is_file(){
  when(actual.isFile()).thenReturn(true);
  files.assertIsFile(someInfo(),actual);
}
