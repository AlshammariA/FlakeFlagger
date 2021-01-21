@Test public void testGetPropertyStatus() throws Exception {
  setupPermission("/a",testPrincipal,false,PrivilegeConstants.REP_READ_NODES);
  testRoot.refresh();
  Tree a=testRoot.getTree("/a");
  assertFalse(a.exists());
  PropertyState p=a.getProperty(JcrConstants.JCR_PRIMARYTYPE);
  assertNotNull(p);
  assertEquals(Tree.Status.UNCHANGED,a.getPropertyStatus(JcrConstants.JCR_PRIMARYTYPE));
}
