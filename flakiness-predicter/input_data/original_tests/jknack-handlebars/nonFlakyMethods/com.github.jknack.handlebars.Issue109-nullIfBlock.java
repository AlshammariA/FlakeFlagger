@Test public void nullIfBlock() throws IOException {
  shouldCompileTo("{{#if null}}truthy{{else}}falsy{{/if}}",$,"falsy");
}
