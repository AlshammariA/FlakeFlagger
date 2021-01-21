@Test public void blockWithDeepNestedComplexLookup() throws IOException {
  String string="{{#outer}}Goodbye {{#inner}}cruel {{../../omg}}{{/inner}}{{/outer}}";
  Object hash=$("omg","OMG!","outer",new Object[]{$("inner",new Object[]{$("text","goodbye")})});
  shouldCompileTo(string,hash,"Goodbye cruel OMG!");
}
