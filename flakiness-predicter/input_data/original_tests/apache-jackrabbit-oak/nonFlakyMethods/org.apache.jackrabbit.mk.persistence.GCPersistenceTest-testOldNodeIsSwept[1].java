@Test public void testOldNodeIsSwept() throws Exception {
  MutableNode node=new MutableNode(null);
  Id id=pm.writeNode(node);
  Thread.sleep(1);
  pm.start();
  pm.sweep();
  try {
    pm.readNode(new StoredNode(id,null));
    fail();
  }
 catch (  NotFoundException e) {
  }
}
