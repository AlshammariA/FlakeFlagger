@Test public void should_pass_if_actual_is_absolute_path(){
  when(actual.isAbsolute()).thenReturn(true);
  files.assertIsAbsolute(someInfo(),actual);
}
