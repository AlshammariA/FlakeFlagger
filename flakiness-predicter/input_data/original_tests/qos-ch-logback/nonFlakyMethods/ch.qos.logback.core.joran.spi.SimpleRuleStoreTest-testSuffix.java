@Test public void testSuffix() throws Exception {
  srs.addRule(new ElementSelector("a"),new XAction());
  srs.addRule(new ElementSelector("a/*"),new YAction());
  for (  String s : cc.combinations("a/b")) {
    List<Action> r=srs.matchActions(new ElementPath(s));
    assertNotNull(r);
    assertEquals(1,r.size());
    assertTrue(r.get(0) instanceof YAction);
  }
}
