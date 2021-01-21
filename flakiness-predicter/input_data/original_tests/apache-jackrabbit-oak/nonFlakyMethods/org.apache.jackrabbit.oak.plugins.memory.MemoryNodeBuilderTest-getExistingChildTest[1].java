@Test public void getExistingChildTest(){
  NodeBuilder rootBuilder=base.builder();
  NodeBuilder x=rootBuilder.getChildNode("x");
  assertTrue(x.exists());
  assertTrue(x.getNodeState().exists());
}
