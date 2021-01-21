@Test public void should_fail_if_actual_has_no_parent() throws IOException {
  when(actual.toRealPath()).thenReturn(canonicalActual);
  when(expected.toRealPath()).thenReturn(canonicalExpected);
  when(canonicalActual.getParent()).thenReturn(null);
  try {
    paths.assertHasParent(info,actual,expected);
    wasExpectingAssertionError();
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldHaveParent(actual,expected));
  }
}
