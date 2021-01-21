@Test public void testDeepSuffix() throws Exception {
  srs.addRule(new ElementSelector("a"),new XAction(1));
  srs.addRule(new ElementSelector("a/b/*"),new XAction(2));
  for (  String s : cc.combinations("a/other")) {
    List<Action> r=srs.matchActions(new ElementPath(s));
    assertNull(r);
  }
}
