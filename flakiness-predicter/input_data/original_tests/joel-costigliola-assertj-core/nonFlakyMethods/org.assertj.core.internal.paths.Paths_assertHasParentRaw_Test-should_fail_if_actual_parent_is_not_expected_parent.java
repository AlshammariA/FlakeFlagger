@Test public void should_fail_if_actual_parent_is_not_expected_parent() throws IOException {
  final Path actualParent=mock(Path.class);
  when(actual.getParent()).thenReturn(actualParent);
  try {
    paths.assertHasParentRaw(info,actual,expectedParent);
    wasExpectingAssertionError();
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldHaveParent(actual,actualParent,expectedParent));
  }
}
