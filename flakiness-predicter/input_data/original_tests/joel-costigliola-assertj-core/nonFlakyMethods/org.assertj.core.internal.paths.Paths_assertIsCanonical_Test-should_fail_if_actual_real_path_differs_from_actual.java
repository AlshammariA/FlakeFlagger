@Test public void should_fail_if_actual_real_path_differs_from_actual() throws IOException {
  final Path other=mock(Path.class);
  when(actual.toRealPath()).thenReturn(other);
  try {
    paths.assertIsCanonical(info,actual);
    wasExpectingAssertionError();
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeCanonicalPath(actual));
  }
}
