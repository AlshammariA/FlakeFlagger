@Test public void emptyStringMustacheBlock() throws IOException {
  shouldCompileTo("{{#empty}}truthy{{/empty}}",$("empty",""),"");
}
