@Test public void stringHash() throws IOException {
  shouldCompileTo("{{var h=\"Hey!\"}}",$,"String:Hey!");
}
