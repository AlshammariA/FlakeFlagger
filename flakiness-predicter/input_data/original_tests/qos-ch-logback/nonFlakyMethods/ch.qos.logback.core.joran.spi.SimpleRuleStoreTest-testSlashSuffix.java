@Test public void testSlashSuffix() throws Exception {
  ElementSelector pa=new ElementSelector("a/");
  srs.addRule(pa,new XAction());
  for (  String s : cc.combinations("a")) {
    List<Action> r=srs.matchActions(new ElementPath(s));
    assertNotNull(r);
    assertEquals(1,r.size());
    if (!(r.get(0) instanceof XAction)) {
      fail("Wrong type");
    }
  }
}
