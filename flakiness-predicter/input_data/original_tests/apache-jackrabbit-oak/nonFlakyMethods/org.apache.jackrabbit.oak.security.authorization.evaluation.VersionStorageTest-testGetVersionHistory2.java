@Test public void testGetVersionHistory2() throws Exception {
  setupPermission("/",testPrincipal,true,PrivilegeConstants.JCR_READ);
  Tree vs=getTestRoot().getTree(vhPath);
  assertTrue(vs.exists());
}
