@Test public void testExistingStatus(){
  NodeBuilder root=base.builder();
  NodeBuilder x=root.child("x");
  assertTrue(x.exists());
  assertFalse(x.isNew());
  assertFalse(x.isModified());
}
