@Test public void testArrayValues(){
  Predicate predicate;
  for (  String string : new String[]{"contains[value=%{i,Content-Type}, search=text]","contains[value=\"%{i,Content-Type}\", search={text}]","contains[value=\"%{i,Content-Type}\", search={text, \"other text\"}]"}) {
    try {
      predicate=PredicateParser.parse(string,PredicateParsingTestCase.class.getClassLoader());
      HttpServerExchange e=new HttpServerExchange(null);
      Assert.assertFalse(predicate.resolve(e));
      e.getRequestHeaders().add(Headers.CONTENT_TYPE,"text");
      Assert.assertTrue(predicate.resolve(e));
    }
 catch (    Throwable ex) {
      throw new RuntimeException("String " + string,ex);
    }
  }
}
