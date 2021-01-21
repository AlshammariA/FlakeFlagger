@Test public void testIsGranted(){
  for (  String path : paths) {
    ImmutableTree tree=new ImmutableRoot(root).getTree(path);
    assertTrue(tree.exists());
    assertTrue(all.isGranted(tree,null,Permissions.ALL));
    for (    PropertyState prop : tree.getProperties()) {
      assertTrue(all.isGranted(tree,prop,Permissions.ALL));
    }
    for (    Tree child : tree.getChildren()) {
      assertTrue(all.isGranted((ImmutableTree)child,null,Permissions.ALL));
    }
  }
}
