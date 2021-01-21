@Test public void testRead() throws IOException {
  StubByteStore store=store(20);
  ByteStoreFileChannel channel=channel(store,READ);
  assertEquals(0,channel.position());
  ByteBuffer buf=buffer("1234567890");
  ByteBuffer buf2=buffer("123457890");
  assertEquals(10,channel.read(buf));
  assertEquals(10,channel.position());
  buf.flip();
  assertEquals(10,channel.read(new ByteBuffer[]{buf,buf2}));
  assertEquals(20,channel.position());
  buf.flip();
  buf2.flip();
  store.setSize(30);
  assertEquals(10,channel.read(new ByteBuffer[]{buf,buf2},0,2));
  assertEquals(30,channel.position());
  buf.flip();
  assertEquals(10,channel.read(buf,5));
  assertEquals(30,channel.position());
  buf.flip();
  assertEquals(-1,channel.read(buf));
  assertEquals(30,channel.position());
}
