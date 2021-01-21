@Test public void should_pass_if_actual_has_expected_extension() throws Exception {
  when(actual.isFile()).thenReturn(true);
  when(actual.getName()).thenReturn("file.java");
  files.assertHasExtension(someInfo(),actual,expectedExtension);
}
