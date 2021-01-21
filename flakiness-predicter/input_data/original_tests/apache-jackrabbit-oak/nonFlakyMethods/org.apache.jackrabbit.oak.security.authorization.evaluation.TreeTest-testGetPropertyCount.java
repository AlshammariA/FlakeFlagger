@Test public void testGetPropertyCount() throws Exception {
  setupPermission("/a",testPrincipal,false,PrivilegeConstants.REP_READ_PROPERTIES);
  testRoot.refresh();
  Tree a=testRoot.getTree("/a");
  assertEquals(0,a.getPropertyCount());
}
