@Test public void shouldLocateRecursiveWildcardResources() throws IOException {
  victim.locate(createUri("**.css"));
}
