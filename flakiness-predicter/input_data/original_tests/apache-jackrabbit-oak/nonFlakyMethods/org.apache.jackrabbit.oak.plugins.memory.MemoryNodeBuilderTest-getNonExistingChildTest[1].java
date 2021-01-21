@Test public void getNonExistingChildTest(){
  NodeBuilder rootBuilder=base.builder();
  NodeBuilder any=rootBuilder.getChildNode("any");
  assertFalse(any.getChildNode("other").exists());
  assertFalse(any.exists());
  try {
    any.setChildNode("any");
    fail();
  }
 catch (  IllegalStateException expected) {
  }
}
