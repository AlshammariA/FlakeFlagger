@Test public void testRemovedStatus(){
  NodeBuilder root=base.builder();
  NodeBuilder x=root.child("x");
  root.getChildNode("x").remove();
  assertFalse(x.exists());
  assertFalse(x.isNew());
  assertFalse(x.isModified());
}
