@Test public void objectArray() throws IOException {
  Hash hash=$("list",new Object[]{"w","o","r","l","d"});
  shouldCompileTo("Hello {{#list}}{{this}}{{/list}}!",hash,"Hello world!");
}
