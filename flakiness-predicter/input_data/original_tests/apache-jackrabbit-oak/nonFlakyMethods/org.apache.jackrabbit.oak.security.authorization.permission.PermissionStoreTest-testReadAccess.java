@Test public void testReadAccess(){
  Tree ps=testRoot.getTree(PermissionConstants.PERMISSIONS_STORE_PATH);
  assertFalse(ps.exists());
}
