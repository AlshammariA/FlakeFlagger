@Test public void stringArray() throws IOException {
  Hash hash=$("list",new String[]{"w","o","r","l","d"});
  shouldCompileTo("Hello {{#list}}{{this}}{{/list}}!",hash,"Hello world!");
}
