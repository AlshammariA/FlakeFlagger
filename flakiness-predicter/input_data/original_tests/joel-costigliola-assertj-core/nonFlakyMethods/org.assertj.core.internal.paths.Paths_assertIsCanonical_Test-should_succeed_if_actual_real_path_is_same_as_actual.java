@Test public void should_succeed_if_actual_real_path_is_same_as_actual() throws IOException {
  when(actual.toRealPath()).thenReturn(actual);
  paths.assertIsCanonical(info,actual);
}
