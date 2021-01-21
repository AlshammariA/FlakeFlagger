@Test public void testGetProperty() throws Exception {
  setupPermission("/a",testPrincipal,false,PrivilegeConstants.REP_READ_PROPERTIES);
  testRoot.refresh();
  Tree a=testRoot.getTree("/a");
  assertNull(a.getProperty("aProp"));
}
