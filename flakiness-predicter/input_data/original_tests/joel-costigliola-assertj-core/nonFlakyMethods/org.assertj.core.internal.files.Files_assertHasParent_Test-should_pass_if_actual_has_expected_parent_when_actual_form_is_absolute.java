@Test public void should_pass_if_actual_has_expected_parent_when_actual_form_is_absolute() throws Exception {
  files.assertHasParent(someInfo(),actual.getAbsoluteFile(),expectedParent);
}
