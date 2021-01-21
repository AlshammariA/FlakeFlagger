@Test public void complexButEmptyPaths() throws IOException {
  shouldCompileTo("{{person/name}}","{person: {name: null}}","");
  shouldCompileTo("{{person/name}}","{person: {}}","");
}
