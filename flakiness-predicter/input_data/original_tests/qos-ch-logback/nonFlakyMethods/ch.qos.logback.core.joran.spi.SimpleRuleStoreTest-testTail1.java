@Test public void testTail1() throws Exception {
  srs.addRule(new ElementSelector("*/b"),new XAction());
  for (  String s : cc.combinations("a/b")) {
    List<Action> r=srs.matchActions(new ElementPath(s));
    assertNotNull(r);
    assertEquals(1,r.size());
    if (!(r.get(0) instanceof XAction)) {
      fail("Wrong type");
    }
  }
}
