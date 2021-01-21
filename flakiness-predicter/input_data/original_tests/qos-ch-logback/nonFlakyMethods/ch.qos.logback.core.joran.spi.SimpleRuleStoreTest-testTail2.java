@Test public void testTail2() throws Exception {
  SimpleRuleStore srs=new SimpleRuleStore(new ContextBase());
  srs.addRule(new ElementSelector("*/c"),new XAction());
  for (  String s : cc.combinations("a/b/c")) {
    List<Action> r=srs.matchActions(new ElementPath(s));
    assertNotNull(r);
    assertEquals(1,r.size());
    if (!(r.get(0) instanceof XAction)) {
      fail("Wrong type");
    }
  }
}
