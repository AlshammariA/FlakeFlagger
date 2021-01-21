@Test public void testSize() throws IOException {
  StubByteStore store=store(10);
  ByteStoreFileChannel channel=channel(store,READ);
  assertEquals(10,channel.size());
  store.setSize(100);
  assertEquals(100,channel.size());
}
