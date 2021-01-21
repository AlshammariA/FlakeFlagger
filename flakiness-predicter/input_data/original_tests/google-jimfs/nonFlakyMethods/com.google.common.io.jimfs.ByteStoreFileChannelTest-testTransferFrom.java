@Test public void testTransferFrom() throws IOException {
  ByteStore store=store(0);
  ByteStoreFileChannel channel=channel(store,WRITE);
  ByteBufferChannel readChannel=new ByteBufferChannel(buffer("1234567890"));
  assertEquals(10,channel.transferFrom(readChannel,0,100));
  assertEquals(0,channel.position());
}
