@Test public void navigateNonExistingNode(){
  NodeBuilder rootBuilder=EMPTY_NODE.builder();
  rootBuilder.child("a").setChildNode("b",createBC(false));
  NodeState r=rootBuilder.getNodeState();
  NodeState a=r.getChildNode("a");
  NodeState b=a.getChildNode("b");
  NodeState c=b.getChildNode("c");
  assertTrue(a.exists());
  assertFalse(b.exists());
  assertTrue(c.exists());
  assertTrue(c.hasProperty("c"));
  NodeBuilder aBuilder=rootBuilder.getChildNode("a");
  NodeBuilder bBuilder=aBuilder.getChildNode("b");
  NodeBuilder cBuilder=bBuilder.getChildNode("c");
  assertTrue(aBuilder.exists());
  assertTrue(cBuilder.exists());
  cBuilder.setProperty("c2","c2Value");
  r=rootBuilder.getNodeState();
  a=r.getChildNode("a");
  b=a.getChildNode("b");
  c=b.getChildNode("c");
  assertTrue(a.exists());
  assertFalse(b.exists());
  assertTrue(c.exists());
  assertTrue(c.hasProperty("c"));
  assertTrue(c.hasProperty("c2"));
}
