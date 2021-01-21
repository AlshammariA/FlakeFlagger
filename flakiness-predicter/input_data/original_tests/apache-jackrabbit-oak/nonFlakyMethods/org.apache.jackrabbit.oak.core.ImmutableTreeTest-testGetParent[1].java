@Test public void testGetParent(){
  ImmutableTree tree=new ImmutableTree(mutableTree.getNodeState());
  try {
    tree.getParent();
    fail();
  }
 catch (  IllegalStateException expected) {
  }
  ImmutableTree child=tree.getChild("x");
  assertNotNull(child.getParent());
  assertEquals("/",child.getParent().getPath());
  ImmutableTree disconnected=new ImmutableTree(ImmutableTree.ParentProvider.UNSUPPORTED,child.getName(),child.getNodeState());
  try {
    disconnected.getParent();
  }
 catch (  UnsupportedOperationException e) {
  }
}
