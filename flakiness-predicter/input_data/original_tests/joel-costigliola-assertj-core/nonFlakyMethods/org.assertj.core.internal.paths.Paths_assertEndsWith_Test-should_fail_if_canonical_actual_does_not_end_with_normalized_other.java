@Test public void should_fail_if_canonical_actual_does_not_end_with_normalized_other() throws IOException {
  final Path canonicalActual=mock(Path.class);
  final Path normalizedOther=mock(Path.class);
  when(actual.toRealPath()).thenReturn(canonicalActual);
  when(other.normalize()).thenReturn(normalizedOther);
  when(canonicalActual.endsWith(normalizedOther)).thenReturn(false);
  try {
    paths.assertEndsWith(info,actual,other);
    wasExpectingAssertionError();
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldEndWith(actual,other));
  }
}
