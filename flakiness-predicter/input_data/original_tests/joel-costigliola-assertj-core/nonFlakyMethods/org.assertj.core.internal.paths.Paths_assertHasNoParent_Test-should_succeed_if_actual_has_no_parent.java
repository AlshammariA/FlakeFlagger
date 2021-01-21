@Test public void should_succeed_if_actual_has_no_parent() throws IOException {
  final Path canonicalActual=mock(Path.class);
  when(actual.toRealPath()).thenReturn(canonicalActual);
  when(canonicalActual.getParent()).thenReturn(null);
  paths.assertHasNoParent(info,actual);
}
