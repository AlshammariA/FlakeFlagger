@Test public void should_fail_if_actual_has_no_parent() throws IOException {
  when(actual.getParent()).thenReturn(null);
  try {
    paths.assertHasParentRaw(info,actual,expectedParent);
    wasExpectingAssertionError();
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldHaveParent(actual,expectedParent));
  }
}
