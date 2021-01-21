@Test public void testUnknownWord() throws Exception {
  Parser<Object> p=new Parser<Object>("%unknown");
  p.setContext(context);
  Node t=p.parse();
  p.compile(t,converterMap);
  StatusChecker checker=new StatusChecker(context.getStatusManager());
  checker.assertContainsMatch("\\[unknown] is not a valid conversion word");
}
