@Test public void should_fail_if_actual_has_parent() throws IOException {
  final Path parent=mock(Path.class);
  when(actual.getParent()).thenReturn(parent);
  try {
    paths.assertHasNoParentRaw(info,actual);
    wasExpectingAssertionError();
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldHaveNoParent(actual));
  }
}
