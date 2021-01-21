@Test public void testMarkedNodeIsNotSwept() throws Exception {
  MutableNode node=new MutableNode(null);
  Id id=pm.writeNode(node);
  Thread.sleep(100);
  pm.start();
  assertTrue(pm.markNode(id));
  pm.sweep();
  pm.readNode(new StoredNode(id,null));
}
