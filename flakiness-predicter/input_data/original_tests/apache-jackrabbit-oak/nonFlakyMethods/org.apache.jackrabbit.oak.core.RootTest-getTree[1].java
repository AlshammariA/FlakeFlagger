@Test public void getTree(){
  Root root=session.getLatestRoot();
  List<String> validPaths=new ArrayList<String>();
  validPaths.add("/");
  validPaths.add("/x");
  validPaths.add("/x/xx");
  validPaths.add("/y");
  validPaths.add("/z");
  for (  String treePath : validPaths) {
    Tree tree=root.getTree(treePath);
    assertTrue(tree.exists());
    assertEquals(treePath,tree.getPath());
  }
  List<String> invalidPaths=new ArrayList<String>();
  invalidPaths.add("/any");
  invalidPaths.add("/x/any");
  for (  String treePath : invalidPaths) {
    assertFalse(root.getTree(treePath).exists());
  }
}
