@Test public void testGetPropertyLocation3() throws Exception {
  setupPermission("/a",testPrincipal,true,PrivilegeConstants.REP_READ_PROPERTIES);
  setupPermission("/a/b",testPrincipal,false,PrivilegeConstants.REP_READ_PROPERTIES);
  setupPermission("/a/b/c",testPrincipal,true,PrivilegeConstants.REP_READ_PROPERTIES);
  Root testRoot=getTestRoot();
  List<String> accessible=ImmutableList.of("/a/aProp","/a/bb/bbProp","/a/b/c/cProp");
  for (  String path : accessible) {
    PropertyState property=testRoot.getTree(PathUtils.getParentPath(path)).getProperty(PathUtils.getName(path));
    assertNotNull(path,property);
  }
  List<String> notAccessible=ImmutableList.of("/jcr:primaryType","/a/b/bProp");
  for (  String path : notAccessible) {
    PropertyState property=testRoot.getTree(PathUtils.getParentPath(path)).getProperty(PathUtils.getName(path));
    assertNull(path,property);
  }
}
