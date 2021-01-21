@Test public void arrayWithIndex() throws IOException {
  String string="{{#goodbyes}}{{@index}}. {{text}}! {{/goodbyes}}cruel {{world}}!";
  Object hash=$("goodbyes",new Object[]{$("text","goodbye"),$("text","Goodbye"),$("text","GOODBYE")},"world","world");
  shouldCompileTo(string,hash,"0. goodbye! 1. Goodbye! 2. GOODBYE! cruel world!","The @index variable is used");
}
