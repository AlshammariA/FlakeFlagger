@Test public void should_fail_if_actual_has_parent() throws IOException {
  final Path canonicalActual=mock(Path.class);
  final Path parent=mock(Path.class);
  when(actual.toRealPath()).thenReturn(canonicalActual);
  when(canonicalActual.getParent()).thenReturn(parent);
  try {
    paths.assertHasNoParent(info,actual);
    wasExpectingAssertionError();
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldHaveNoParent(actual));
  }
}
