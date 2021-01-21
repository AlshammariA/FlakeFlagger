@Test public void testPrefixSuffixInteraction2() throws Exception {
  srs.addRule(new ElementSelector("tG"),new XAction());
  srs.addRule(new ElementSelector("tG/tS"),new YAction());
  srs.addRule(new ElementSelector("tG/tS/test"),new ZAction());
  srs.addRule(new ElementSelector("tG/tS/test/*"),new XAction(9));
  for (  String s : cc.combinations("tG/tS/toto")) {
    List<Action> r=srs.matchActions(new ElementPath(s));
    assertNull(r);
  }
}
