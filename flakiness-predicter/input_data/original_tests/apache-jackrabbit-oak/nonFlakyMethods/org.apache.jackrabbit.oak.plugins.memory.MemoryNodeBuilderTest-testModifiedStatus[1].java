@Test public void testModifiedStatus(){
  NodeBuilder root=base.builder();
  NodeBuilder x=root.child("x");
  x.setProperty("p","pValue");
  assertTrue(x.exists());
  assertFalse(x.isNew());
  assertTrue(x.isModified());
}
