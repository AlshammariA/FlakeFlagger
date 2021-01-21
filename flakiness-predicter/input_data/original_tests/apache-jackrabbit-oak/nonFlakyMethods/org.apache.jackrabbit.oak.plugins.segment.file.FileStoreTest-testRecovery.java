@Test public void testRecovery() throws IOException {
  FileStore store=new FileStore(directory,1,false);
  store.flush();
  SegmentNodeState base=store.getHead();
  SegmentNodeBuilder builder=base.builder();
  builder.setProperty("step","a");
  store.setHead(base,builder.getNodeState());
  store.flush();
  base=store.getHead();
  builder=base.builder();
  builder.setProperty("step","b");
  store.setHead(base,builder.getNodeState());
  store.close();
  store=new FileStore(directory,1,false);
  assertEquals("b",store.getHead().getString("step"));
  store.close();
  RandomAccessFile file=new RandomAccessFile(new File(directory,"data00000a.tar"),"rw");
  file.setLength(2048);
  file.close();
  store=new FileStore(directory,1,false);
  assertEquals("a",store.getHead().getString("step"));
  store.close();
  file=new RandomAccessFile(new File(directory,"data00000a.tar"),"rw");
  file.setLength(1024);
  file.close();
  store=new FileStore(directory,1,false);
  assertFalse(store.getHead().hasProperty("step"));
  store.close();
}
