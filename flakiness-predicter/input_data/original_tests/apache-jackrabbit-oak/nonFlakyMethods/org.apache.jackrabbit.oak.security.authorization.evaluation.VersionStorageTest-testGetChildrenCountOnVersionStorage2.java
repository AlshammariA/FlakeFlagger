@Test public void testGetChildrenCountOnVersionStorage2() throws Exception {
  setupPermission("/",testPrincipal,true,PrivilegeConstants.JCR_READ);
  Tree vs=getTestRoot().getTree(VersionConstants.VERSION_STORE_PATH);
  vs.getChildrenCount(Long.MAX_VALUE);
}
