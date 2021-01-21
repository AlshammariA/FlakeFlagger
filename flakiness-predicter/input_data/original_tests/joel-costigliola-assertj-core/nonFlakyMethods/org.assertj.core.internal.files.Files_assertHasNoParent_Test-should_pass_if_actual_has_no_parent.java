@Test public void should_pass_if_actual_has_no_parent() throws Exception {
  when(actual.getParentFile()).thenReturn(null);
  files.assertHasNoParent(someInfo(),actual);
}
