@Test public void addNewChildTest(){
  NodeBuilder rootBuilder=base.builder();
  NodeBuilder x=rootBuilder.setChildNode("any");
  assertTrue(x.exists());
  assertTrue(x.getNodeState().exists());
}
