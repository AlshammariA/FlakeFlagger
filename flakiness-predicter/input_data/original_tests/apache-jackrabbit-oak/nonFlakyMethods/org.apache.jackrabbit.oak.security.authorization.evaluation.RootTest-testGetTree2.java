@Test public void testGetTree2() throws Exception {
  setupPermission("/a",testPrincipal,true,PrivilegeConstants.JCR_READ);
  setupPermission("/a/b",testPrincipal,false,PrivilegeConstants.JCR_READ);
  setupPermission("/a/b/c",testPrincipal,true,PrivilegeConstants.JCR_READ);
  Root testRoot=getTestRoot();
  List<String> notAccessible=ImmutableList.of("/","/a/b");
  for (  String path : notAccessible) {
    assertFalse(path,testRoot.getTree(path).exists());
  }
  List<String> accessible=ImmutableList.of("/a","/a/bb","/a/b/c");
  for (  String path : accessible) {
    assertTrue(path,testRoot.getTree(path).exists());
  }
}
