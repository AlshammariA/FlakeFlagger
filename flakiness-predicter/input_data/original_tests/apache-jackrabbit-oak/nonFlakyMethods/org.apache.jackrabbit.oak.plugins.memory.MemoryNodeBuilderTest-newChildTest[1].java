@Test public void newChildTest(){
  NodeBuilder rootBuilder=base.builder();
  NodeBuilder x=rootBuilder.child("any");
  assertTrue(x.exists());
  assertTrue(x.getNodeState().exists());
}
