@Test public void testReadsInWriteOnlyMode() throws IOException {
  ByteStoreFileChannel channel=channel(store(0),WRITE);
  try {
    channel.read(buffer("111"));
    fail();
  }
 catch (  NonReadableChannelException expected) {
  }
  try {
    channel.read(buffer("111"),10);
    fail();
  }
 catch (  NonReadableChannelException expected) {
  }
  try {
    channel.read(new ByteBuffer[]{buffer("111"),buffer("111")});
    fail();
  }
 catch (  NonReadableChannelException expected) {
  }
  try {
    channel.read(new ByteBuffer[]{buffer("111"),buffer("111")},0,2);
    fail();
  }
 catch (  NonReadableChannelException expected) {
  }
  try {
    channel.transferTo(0,10,new ByteBufferChannel(buffer("111")));
    fail();
  }
 catch (  NonReadableChannelException expected) {
  }
  try {
    channel.lock(0,10,true);
  }
 catch (  NonReadableChannelException expected) {
  }
}
