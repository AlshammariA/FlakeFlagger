@Test public void nullElseBlock() throws IOException {
  shouldCompileTo("{{^null}}falsy{{/null}}",$,"falsy");
}
