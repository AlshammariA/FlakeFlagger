@Test public void nullMustacheBlock() throws IOException {
  shouldCompileTo("{{#null}}truthy{{/null}}",$,"");
}
