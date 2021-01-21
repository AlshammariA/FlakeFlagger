@Test public void testRoot(){
  ImmutableTree tree=new ImmutableTree(mutableTree.getNodeState());
  assertTrue(tree.isRoot());
  try {
    tree.getParent();
    fail();
  }
 catch (  IllegalStateException expected) {
  }
  assertEquals("",tree.getName());
}
