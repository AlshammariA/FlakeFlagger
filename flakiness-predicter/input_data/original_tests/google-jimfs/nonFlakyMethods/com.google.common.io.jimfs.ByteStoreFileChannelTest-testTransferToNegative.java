@Test public void testTransferToNegative() throws IOException {
  ByteStoreFileChannel channel=channel(store(0),READ,WRITE);
  try {
    channel.transferTo(-1,0,new ByteBufferChannel(10));
    fail();
  }
 catch (  IllegalArgumentException expected) {
  }
  try {
    channel.transferTo(0,-1,new ByteBufferChannel(10));
    fail();
  }
 catch (  IllegalArgumentException expected) {
  }
}
