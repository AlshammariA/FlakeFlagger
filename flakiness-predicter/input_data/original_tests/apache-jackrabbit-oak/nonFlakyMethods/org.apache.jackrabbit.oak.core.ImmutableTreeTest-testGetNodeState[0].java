@Test public void testGetNodeState(){
  ImmutableTree tree=new ImmutableTree(mutableTree.getNodeState());
  assertNotNull(tree.getNodeState());
  for (  Tree child : tree.getChildren()) {
    assertTrue(child instanceof ImmutableTree);
    assertNotNull(((ImmutableTree)child).getNodeState());
  }
}
