@Test public void testGetNodeLocation2() throws Exception {
  setupPermission("/a",testPrincipal,true,PrivilegeConstants.REP_READ_NODES);
  setupPermission("/a/b",testPrincipal,false,PrivilegeConstants.REP_READ_NODES);
  setupPermission("/a/b/c",testPrincipal,true,PrivilegeConstants.REP_READ_NODES);
  Root testRoot=getTestRoot();
  List<String> notAccessible=ImmutableList.of("/","/a/b");
  for (  String path : notAccessible) {
    Tree tree=testRoot.getTree(path);
    assertNotNull(path,tree);
    assertFalse(tree.exists());
  }
  List<String> accessible=ImmutableList.of("/a","/a/bb","/a/b/c");
  for (  String path : accessible) {
    Tree tree=testRoot.getTree(path);
    assertNotNull(path,tree);
    assertTrue(tree.exists());
  }
}
