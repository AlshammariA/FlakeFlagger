@Test public void testTruncate() throws IOException {
  ByteStore store=store(10);
  ByteStoreFileChannel channel=channel(store,WRITE);
  channel.truncate(10);
  assertEquals(10,store.size());
  channel.truncate(11);
  assertEquals(10,store.size());
  channel.truncate(5);
  assertEquals(5,store.size());
  channel.position(20);
  channel.truncate(10);
  assertEquals(10,channel.position());
  channel.truncate(2);
  assertEquals(2,channel.position());
}
