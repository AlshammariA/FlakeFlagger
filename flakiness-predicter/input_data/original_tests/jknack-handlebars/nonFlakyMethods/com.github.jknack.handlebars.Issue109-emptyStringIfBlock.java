@Test public void emptyStringIfBlock() throws IOException {
  shouldCompileTo("{{#if empty}}truthy{{else}}falsy{{/if}}",$("empty",""),"falsy");
}
