@Test public void shouldLocateWildcard3Resources() throws IOException {
  victim.locate(createUri("*.???"));
}
