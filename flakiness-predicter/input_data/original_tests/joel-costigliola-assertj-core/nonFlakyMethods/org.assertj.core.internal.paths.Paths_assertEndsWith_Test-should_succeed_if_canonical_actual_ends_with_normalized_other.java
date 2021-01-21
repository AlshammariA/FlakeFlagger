@Test public void should_succeed_if_canonical_actual_ends_with_normalized_other() throws IOException {
  final Path canonicalActual=mock(Path.class);
  final Path normalizedOther=mock(Path.class);
  when(actual.toRealPath()).thenReturn(canonicalActual);
  when(other.normalize()).thenReturn(normalizedOther);
  when(canonicalActual.endsWith(normalizedOther)).thenReturn(true);
  paths.assertEndsWith(info,actual,other);
}
