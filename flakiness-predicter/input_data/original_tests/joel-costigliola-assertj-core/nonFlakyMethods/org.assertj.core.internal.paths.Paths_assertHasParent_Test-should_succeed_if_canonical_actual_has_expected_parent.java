@Test public void should_succeed_if_canonical_actual_has_expected_parent() throws IOException {
  when(actual.toRealPath()).thenReturn(canonicalActual);
  when(expected.toRealPath()).thenReturn(canonicalExpected);
  when(canonicalActual.getParent()).thenReturn(canonicalExpected);
  paths.assertHasParent(info,actual,expected);
}
