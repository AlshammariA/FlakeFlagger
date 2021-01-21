@Test public void testWrite() throws IOException {
  ByteStore store=store(0);
  ByteStoreFileChannel channel=channel(store,WRITE);
  assertEquals(0,channel.position());
  ByteBuffer buf=buffer("1234567890");
  ByteBuffer buf2=buffer("1234567890");
  assertEquals(10,channel.write(buf));
  assertEquals(10,channel.position());
  buf.flip();
  assertEquals(20,channel.write(new ByteBuffer[]{buf,buf2}));
  assertEquals(30,channel.position());
  buf.flip();
  buf2.flip();
  assertEquals(20,channel.write(new ByteBuffer[]{buf,buf2},0,2));
  assertEquals(50,channel.position());
  buf.flip();
  assertEquals(10,channel.write(buf,5));
  assertEquals(50,channel.position());
}
