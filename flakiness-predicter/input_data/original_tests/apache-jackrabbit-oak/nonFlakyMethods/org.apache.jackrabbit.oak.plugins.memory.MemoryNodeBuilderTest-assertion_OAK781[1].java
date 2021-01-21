@Test public void assertion_OAK781(){
  NodeBuilder rootBuilder=EMPTY_NODE.builder();
  rootBuilder.child("a").setChildNode("b",createBC(false));
  NodeState r=rootBuilder.getNodeState();
  NodeState a=r.getChildNode("a");
  NodeState b=a.getChildNode("b");
  NodeState c=b.getChildNode("c");
  assertTrue(a.exists());
  assertFalse(b.exists());
  assertTrue(c.exists());
  rootBuilder.child("a").child("b").child("c");
  rootBuilder=new MemoryNodeBuilder(r);
  rootBuilder.child("a").child("b").child("c");
}
