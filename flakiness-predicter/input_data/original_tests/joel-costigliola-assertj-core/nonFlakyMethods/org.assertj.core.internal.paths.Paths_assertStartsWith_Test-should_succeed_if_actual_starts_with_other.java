@Test public void should_succeed_if_actual_starts_with_other() throws IOException {
  when(actual.toRealPath()).thenReturn(canonicalActual);
  when(other.toRealPath()).thenReturn(canonicalOther);
  when(canonicalActual.startsWith(canonicalOther)).thenReturn(true);
  paths.assertStartsWith(info,actual,other);
}
