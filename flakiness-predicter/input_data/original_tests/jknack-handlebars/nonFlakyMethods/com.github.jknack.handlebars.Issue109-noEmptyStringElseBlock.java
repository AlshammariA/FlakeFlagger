@Test public void noEmptyStringElseBlock() throws IOException {
  shouldCompileTo("{{#nonempty}}falsy{{/nonempty}}",$("nonempty","xyz"),"falsy");
}
