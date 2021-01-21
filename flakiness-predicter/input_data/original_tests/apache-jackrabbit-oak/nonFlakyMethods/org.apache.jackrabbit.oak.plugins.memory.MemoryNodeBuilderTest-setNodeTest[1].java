@Test public void setNodeTest(){
  NodeBuilder rootBuilder=EMPTY_NODE.builder();
  rootBuilder.setChildNode("a",createBC(true));
  NodeState c=rootBuilder.getNodeState().getChildNode("a").getChildNode("c");
  assertTrue(c.hasProperty("c"));
  rootBuilder.child("a").child("c").setProperty("c2","c2Value");
  c=rootBuilder.getNodeState().getChildNode("a").getChildNode("c");
  assertTrue(c.hasProperty("c"));
  assertTrue(c.hasProperty("c2"));
}
