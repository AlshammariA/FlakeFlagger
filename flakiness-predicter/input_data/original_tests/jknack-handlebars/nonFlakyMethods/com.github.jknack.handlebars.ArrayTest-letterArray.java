@Test public void letterArray() throws IOException {
  Hash hash=$("list",new Letter[]{new Letter('w'),new Letter('o'),new Letter('r'),new Letter('l'),new Letter('d')});
  shouldCompileTo("Hello {{#list}}{{this}}{{/list}}!",hash,"Hello world!");
}
