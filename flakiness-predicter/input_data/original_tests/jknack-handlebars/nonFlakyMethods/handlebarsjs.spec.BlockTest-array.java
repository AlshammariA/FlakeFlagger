@Test public void array() throws IOException {
  String string="{{#goodbyes}}{{text}}! {{/goodbyes}}cruel {{world}}!";
  Object hash=$("goodbyes",new Object[]{$("text","goodbye"),$("text","Goodbye"),$("text","GOODBYE")},"world","world");
  shouldCompileTo(string,hash,"goodbye! Goodbye! GOODBYE! cruel world!","Arrays iterate over the contents when not empty");
  shouldCompileTo(string,$("goodbyes",new Object[0],"world","world"),"cruel world!","Arrays ignore the contents when empty");
}
