@Test public void testPredicateParser(){
  Predicate predicate=PredicateParser.parse("path[foo]",PredicateParsingTestCase.class.getClassLoader());
  Assert.assertTrue(predicate instanceof PathMatchPredicate);
  HttpServerExchange e=new HttpServerExchange(null);
  e.setRelativePath("foo");
  Assert.assertTrue(predicate.resolve(e));
  e.setRelativePath("bob");
  Assert.assertFalse(predicate.resolve(e));
  for (  String string : new String[]{"not path[\"/foo\"]","not path[foo] and true","false or not path[path=/foo]","false or not path[/foo]","true and not path[foo] or not path[foo] and false"}) {
    try {
      predicate=PredicateParser.parse(string,PredicateParsingTestCase.class.getClassLoader());
      e=new HttpServerExchange(null);
      e.setRelativePath("foo");
      Assert.assertFalse(predicate.resolve(e));
      e.setRelativePath("bob");
      Assert.assertTrue(predicate.resolve(e));
    }
 catch (    Throwable ex) {
      throw new RuntimeException("String " + string,ex);
    }
  }
}
