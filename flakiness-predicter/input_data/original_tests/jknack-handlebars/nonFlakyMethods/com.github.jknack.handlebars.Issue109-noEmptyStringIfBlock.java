@Test public void noEmptyStringIfBlock() throws IOException {
  shouldCompileTo("{{#if nonempty}}truthy{{/if}}",$("nonempty","xyz"),"truthy");
}
