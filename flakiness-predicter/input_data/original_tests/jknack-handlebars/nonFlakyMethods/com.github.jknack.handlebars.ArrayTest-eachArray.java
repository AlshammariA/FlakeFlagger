@Test public void eachArray() throws IOException {
  Hash hash=$("list",new Object[]{"w","o","r","l","d"});
  shouldCompileTo("Hello {{#each list}}{{this}}{{/each}}!",hash,"Hello world!");
}
