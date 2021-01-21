@Test public void testRestore() throws Exception {
  FileStore source=new FileStore(src,256,false);
  NodeStore store=new SegmentNodeStore(source);
  init(store);
  FileStoreBackup.backup(store,destination);
  addTestContent(store);
  FileStoreRestore.restore(destination,store);
  compare(store,destination);
  source.close();
}
