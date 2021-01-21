@Test public void should_fail_if_actual_parent_is_not_expected_parent() throws IOException {
  final Path actualParent=mock(Path.class);
  when(actual.toRealPath()).thenReturn(canonicalActual);
  when(expected.toRealPath()).thenReturn(canonicalExpected);
  when(canonicalActual.getParent()).thenReturn(actualParent);
  try {
    paths.assertHasParent(info,actual,expected);
    wasExpectingAssertionError();
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldHaveParent(actual,actualParent,expected));
  }
}
