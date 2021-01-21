@Test public void testGetNodeLocation3() throws Exception {
  setupPermission("/",testPrincipal,true,PrivilegeConstants.REP_READ_PROPERTIES);
  Root testRoot=getTestRoot();
  List<String> notAccessible=ImmutableList.of("/","/a","/a/b","/a/bb","/a/b/c");
  for (  String path : notAccessible) {
    Tree tree=testRoot.getTree(path);
    assertNotNull(path,tree);
    assertFalse(tree.exists());
  }
}
