@Test public void testHasProperty() throws Exception {
  setupPermission("/a",testPrincipal,false,PrivilegeConstants.REP_READ_PROPERTIES);
  testRoot.refresh();
  Tree a=testRoot.getTree("/a");
  assertFalse(a.hasProperty("aProp"));
}
