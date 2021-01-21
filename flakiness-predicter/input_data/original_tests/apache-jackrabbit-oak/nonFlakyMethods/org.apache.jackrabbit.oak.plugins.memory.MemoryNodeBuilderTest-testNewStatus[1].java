@Test public void testNewStatus(){
  NodeBuilder root=base.builder();
  NodeBuilder n=root.child("n");
  assertTrue(n.exists());
  assertTrue(n.isNew());
  assertFalse(n.isModified());
}
