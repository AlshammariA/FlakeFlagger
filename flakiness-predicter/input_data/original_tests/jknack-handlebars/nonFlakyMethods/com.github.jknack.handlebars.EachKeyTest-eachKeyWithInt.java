@Test public void eachKeyWithInt() throws IOException {
  shouldCompileTo("{{#each this}}{{@key}} {{/each}}",7,"");
}
