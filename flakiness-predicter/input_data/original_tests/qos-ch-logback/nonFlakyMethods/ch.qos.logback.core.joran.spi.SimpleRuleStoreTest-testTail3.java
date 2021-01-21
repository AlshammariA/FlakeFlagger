@Test public void testTail3() throws Exception {
  srs.addRule(new ElementSelector("*/b"),new XAction());
  srs.addRule(new ElementSelector("*/a/b"),new YAction());
  for (  String s : cc.combinations("a/b")) {
    List<Action> r=srs.matchActions(new ElementPath(s));
    assertNotNull(r);
    assertEquals(1,r.size());
    if (!(r.get(0) instanceof YAction)) {
      fail("Wrong type");
    }
  }
}
