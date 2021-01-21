@Test public void testPrefixSuffixInteraction1() throws Exception {
  srs.addRule(new ElementSelector("a"),new ZAction());
  srs.addRule(new ElementSelector("a/*"),new YAction());
  srs.addRule(new ElementSelector("*/a/b"),new XAction(3));
  for (  String s : cc.combinations("a/b")) {
    List<Action> r=srs.matchActions(new ElementPath(s));
    assertNotNull(r);
    assertEquals(1,r.size());
    assertTrue(r.get(0) instanceof XAction);
    XAction xaction=(XAction)r.get(0);
    assertEquals(3,xaction.id);
  }
}
