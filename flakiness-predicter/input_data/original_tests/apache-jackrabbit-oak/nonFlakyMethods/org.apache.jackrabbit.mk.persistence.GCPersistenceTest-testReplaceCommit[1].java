@Test public void testReplaceCommit() throws Exception {
  MutableCommit c1=new MutableCommit();
  c1.setRootNodeId(Id.fromLong(0));
  pm.writeCommit(Id.fromLong(1),c1);
  MutableCommit c2=new MutableCommit();
  c2.setParentId(c1.getId());
  c2.setRootNodeId(Id.fromLong(0));
  pm.writeCommit(Id.fromLong(2),c2);
  pm.start();
  c2=new MutableCommit();
  c2.setRootNodeId(Id.fromLong(0));
  pm.replaceCommit(Id.fromLong(2),c2);
  pm.sweep();
  assertEquals(null,pm.readCommit(Id.fromLong(2)).getParentId());
}
