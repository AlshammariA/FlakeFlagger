@Test public void orderBefore() throws Exception {
  MutableTree t=(MutableTree)root.getTree("/x/y/z");
  t.addChild("node1");
  t.addChild("node2");
  t.addChild("node3");
  t.getChild("node1").orderBefore("node2");
  t.getChild("node3").orderBefore(null);
  root.commit();
  ImmutableTree tree=new ImmutableTree(t.getNodeState());
  assertSequence(tree.getChildren(),"node1","node2","node3");
  t.getChild("node3").orderBefore("node2");
  root.commit();
  tree=new ImmutableTree(t.getNodeState());
  assertSequence(tree.getChildren(),"node1","node3","node2");
  t.getChild("node1").orderBefore(null);
  root.commit();
  tree=new ImmutableTree(t.getNodeState());
  assertSequence(tree.getChildren(),"node3","node2","node1");
}
