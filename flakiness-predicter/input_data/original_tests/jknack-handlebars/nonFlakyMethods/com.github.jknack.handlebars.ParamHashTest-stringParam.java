@Test public void stringParam() throws IOException {
  shouldCompileTo("{{varp . \"Hey!\"}}",$,"String:Hey!");
}
