@Test public void blockHelperForUndefinedValue() throws IOException {
  shouldCompileTo("{{#_empty}}shouldn't render{{/_empty}}",$,"");
}
