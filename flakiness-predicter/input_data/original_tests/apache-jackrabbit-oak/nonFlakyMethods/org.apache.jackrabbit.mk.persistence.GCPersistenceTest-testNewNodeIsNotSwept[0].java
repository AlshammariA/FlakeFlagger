@Test public void testNewNodeIsNotSwept() throws Exception {
  pm.start();
  MutableNode node=new MutableNode(null);
  Id id=pm.writeNode(node);
  assertFalse(pm.markNode(id));
  pm.sweep();
  pm.readNode(new StoredNode(id,null));
}
