@Test public void testGetTreePermission(){
  for (  String path : paths) {
    ImmutableTree tree=new ImmutableRoot(root).getTree(path);
    assertTrue(tree.exists());
    assertSame(TreePermission.ALL,all.getTreePermission(tree,TreePermission.EMPTY));
    for (    Tree child : tree.getChildren()) {
      assertSame(TreePermission.ALL,all.getTreePermission((ImmutableTree)child,TreePermission.EMPTY));
    }
  }
}
