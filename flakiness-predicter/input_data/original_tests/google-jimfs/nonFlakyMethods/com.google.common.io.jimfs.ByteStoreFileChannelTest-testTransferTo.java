@Test public void testTransferTo() throws IOException {
  ByteStore store=store(10);
  ByteStoreFileChannel channel=channel(store,READ);
  ByteBufferChannel writeChannel=new ByteBufferChannel(buffer("1234567890"));
  assertEquals(10,channel.transferTo(0,100,writeChannel));
  assertEquals(0,channel.position());
}
