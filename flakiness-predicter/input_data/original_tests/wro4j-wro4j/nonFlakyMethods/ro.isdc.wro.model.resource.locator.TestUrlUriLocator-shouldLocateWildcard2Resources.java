@Test public void shouldLocateWildcard2Resources() throws IOException {
  victim.locate(createUri("*.cs?"));
}
