@Test public void emptyStringElseBlock() throws IOException {
  shouldCompileTo("{{^empty}}falsy{{/empty}}",$("empty",""),"falsy");
}
