@Test public void should_pass_if_actual_is_relative_path(){
  when(actual.isAbsolute()).thenReturn(false);
  files.assertIsRelative(someInfo(),actual);
}
