@Test public void testBackup() throws Exception {
  FileStore source=new FileStore(src,256,false);
  NodeStore store=new SegmentNodeStore(source);
  init(store);
  FileStoreBackup.backup(store,destination);
  compare(store,destination);
  addTestContent(store);
  FileStoreBackup.backup(store,destination);
  compare(store,destination);
  source.close();
}
