@Test public void emptyBlock() throws IOException {
  String string="{{#goodbyes}}{{/goodbyes}}cruel {{world}}!";
  Object hash=$("goodbyes",new Object[]{$("text","goodbye"),$("text","Goodbye"),$("text","GOODBYE")},"world","world");
  shouldCompileTo(string,hash,"cruel world!","Arrays iterate over the contents when not empty");
  hash=$("goodbyes",new Object[0],"world","world");
  shouldCompileTo(string,hash,"cruel world!","Arrays ignore the contents when empty");
}
