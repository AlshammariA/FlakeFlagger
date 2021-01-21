@Test public void smokeII() throws Exception {
  srs.addRule(new ElementSelector("a/b"),new XAction());
  srs.addRule(new ElementSelector("a/b"),new YAction());
  for (  String s : cc.combinations("a/b")) {
    List<Action> r=srs.matchActions(new ElementPath(s));
    assertNotNull(r);
    assertEquals(2,r.size());
    if (!(r.get(0) instanceof XAction)) {
      fail("Wrong type");
    }
    if (!(r.get(1) instanceof YAction)) {
      fail("Wrong type");
    }
  }
}
