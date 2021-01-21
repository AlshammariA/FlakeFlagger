@Test public void testTransferFromNegative() throws IOException {
  ByteStoreFileChannel channel=channel(store(0),READ,WRITE);
  try {
    channel.transferFrom(new ByteBufferChannel(10),-1,0);
    fail();
  }
 catch (  IllegalArgumentException expected) {
  }
  try {
    channel.transferFrom(new ByteBufferChannel(10),0,-1);
    fail();
  }
 catch (  IllegalArgumentException expected) {
  }
}
