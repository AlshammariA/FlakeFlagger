@Test public void testGetTree() throws Exception {
  setupPermission("/",testPrincipal,true,PrivilegeConstants.JCR_READ);
  setupPermission("/a/bb",testPrincipal,false,PrivilegeConstants.JCR_READ);
  Root testRoot=getTestRoot();
  List<String> accessible=ImmutableList.of("/","/a","/a/b","/a/b/c");
  for (  String path : accessible) {
    assertTrue(testRoot.getTree(path).exists());
  }
  assertFalse(testRoot.getTree("/a/bb").exists());
}
