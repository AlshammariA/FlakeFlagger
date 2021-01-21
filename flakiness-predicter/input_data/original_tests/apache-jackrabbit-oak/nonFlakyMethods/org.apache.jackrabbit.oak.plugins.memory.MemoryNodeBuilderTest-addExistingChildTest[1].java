@Test public void addExistingChildTest(){
  NodeBuilder rootBuilder=base.builder();
  NodeBuilder x=rootBuilder.setChildNode("x");
  assertTrue(x.exists());
  assertTrue(x.getBaseState().exists());
}
