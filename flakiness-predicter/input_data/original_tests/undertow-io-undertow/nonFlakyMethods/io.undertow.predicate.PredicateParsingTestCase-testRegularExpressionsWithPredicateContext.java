@Test public void testRegularExpressionsWithPredicateContext(){
  Predicate predicate=PredicateParser.parse("regex[pattern=a* , value=%{RELATIVE_PATH}] and equals[{$0, aaa}]",PredicateParsingTestCase.class.getClassLoader());
  HttpServerExchange e=new HttpServerExchange(null);
  e.putAttachment(Predicate.PREDICATE_CONTEXT,new HashMap<String,Object>());
  e.setRelativePath("aaab");
  Assert.assertTrue(predicate.resolve(e));
  e.setRelativePath("aaaab");
  Assert.assertFalse(predicate.resolve(e));
  predicate=PredicateParser.parse("regex[pattern='a(b*)a*' , value=%{RELATIVE_PATH}] and equals[$1, bb]",PredicateParsingTestCase.class.getClassLoader());
  e.putAttachment(Predicate.PREDICATE_CONTEXT,new HashMap<String,Object>());
  e.setRelativePath("abb");
  Assert.assertTrue(predicate.resolve(e));
  e.setRelativePath("abbaaa");
  Assert.assertTrue(predicate.resolve(e));
  e.setRelativePath("abbb");
  Assert.assertFalse(predicate.resolve(e));
}
