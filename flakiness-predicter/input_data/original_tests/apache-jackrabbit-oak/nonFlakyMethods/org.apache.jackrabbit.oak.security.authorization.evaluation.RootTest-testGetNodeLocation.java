@Test public void testGetNodeLocation() throws Exception {
  setupPermission("/",testPrincipal,true,PrivilegeConstants.REP_READ_NODES);
  setupPermission("/a/bb",testPrincipal,false,PrivilegeConstants.REP_READ_NODES);
  Root testRoot=getTestRoot();
  List<String> accessible=ImmutableList.of("/","/a","/a/b","/a/b/c");
  for (  String path : accessible) {
    Tree tree=testRoot.getTree(path);
    assertNotNull(tree);
    assertTrue(tree.exists());
  }
  Tree tree=testRoot.getTree("/a/bb");
  assertNotNull(tree);
  assertFalse(tree.exists());
}
