@Test public void thisKeywordInPaths() throws IOException {
  String string="{{#goodbyes}}{{this}}{{/goodbyes}}";
  Object hash=$("goodbyes",new String[]{"goodbye","Goodbye","GOODBYE"});
  shouldCompileTo(string,hash,"goodbyeGoodbyeGOODBYE","This keyword in paths evaluates to current context");
  string="{{#hellos}}{{this/text}}{{/hellos}}";
  hash=$("hellos",new Object[]{$("text","hello"),$("text","Hello"),$("text","HELLO")});
  shouldCompileTo(string,hash,"helloHelloHELLO","This keyword evaluates in more complex paths");
}
