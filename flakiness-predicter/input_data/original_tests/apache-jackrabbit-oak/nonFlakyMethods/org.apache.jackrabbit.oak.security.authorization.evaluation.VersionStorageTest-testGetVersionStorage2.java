@Test public void testGetVersionStorage2() throws Exception {
  setupPermission("/",testPrincipal,true,PrivilegeConstants.JCR_READ);
  Tree vs=getTestRoot().getTree(VersionConstants.VERSION_STORE_PATH);
  assertTrue(vs.exists());
}
