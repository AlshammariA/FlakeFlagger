@Test public void smoke() throws Exception {
  srs.addRule(new ElementSelector("a/b"),new XAction());
  for (  String s : cc.combinations("a/b")) {
    System.out.println("s=" + s);
    List<Action> r=srs.matchActions(new ElementPath(s));
    assertNotNull(r);
    assertEquals(1,r.size());
    if (!(r.get(0) instanceof XAction)) {
      fail("Wrong type");
    }
  }
}
