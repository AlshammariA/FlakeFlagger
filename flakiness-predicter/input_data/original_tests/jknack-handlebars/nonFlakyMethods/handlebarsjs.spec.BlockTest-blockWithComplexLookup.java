@Test public void blockWithComplexLookup() throws IOException {
  String string="{{#goodbyes}}{{text}} cruel {{../name}}! {{/goodbyes}}";
  Object hash=$("goodbyes",new Object[]{$("text","goodbye"),$("text","Goodbye"),$("text","GOODBYE")},"name","Alan");
  shouldCompileTo(string,hash,"goodbye cruel Alan! Goodbye cruel Alan! GOODBYE cruel Alan! ","Templates can access variables in contexts up the stack with relative path syntax");
}
