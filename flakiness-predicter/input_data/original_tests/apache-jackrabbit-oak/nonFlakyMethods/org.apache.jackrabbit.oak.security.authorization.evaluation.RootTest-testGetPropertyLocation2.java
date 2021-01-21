@Test public void testGetPropertyLocation2() throws Exception {
  setupPermission("/",testPrincipal,true,PrivilegeConstants.REP_READ_PROPERTIES);
  Root testRoot=getTestRoot();
  List<String> accessible=ImmutableList.of("/","/a","/a/b","/a/bb","/a/b/c");
  for (  String path : accessible) {
    String propertyPath=PathUtils.concat(path,JcrConstants.JCR_PRIMARYTYPE);
    PropertyState property=testRoot.getTree(path).getProperty(JcrConstants.JCR_PRIMARYTYPE);
    assertNotNull(propertyPath,property);
  }
  List<String> propPaths=ImmutableList.of("/a/aProp","/a/b/bProp","/a/bb/bbProp","/a/b/c/cProp");
  for (  String path : propPaths) {
    PropertyState property=testRoot.getTree(PathUtils.getParentPath(path)).getProperty(PathUtils.getName(path));
    assertNotNull(path,property);
  }
}
