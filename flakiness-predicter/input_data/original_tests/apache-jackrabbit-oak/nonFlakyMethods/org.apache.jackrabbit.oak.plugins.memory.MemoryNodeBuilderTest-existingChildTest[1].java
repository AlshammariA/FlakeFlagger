@Test public void existingChildTest(){
  NodeBuilder rootBuilder=base.builder();
  NodeBuilder x=rootBuilder.child("x");
  assertTrue(x.exists());
  assertTrue(x.getBaseState().exists());
}
