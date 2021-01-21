@Test public void testWritesInReadOnlyMode() throws IOException {
  ByteStoreFileChannel channel=channel(store(0),READ);
  try {
    channel.write(buffer("111"));
    fail();
  }
 catch (  NonWritableChannelException expected) {
  }
  try {
    channel.write(buffer("111"),10);
    fail();
  }
 catch (  NonWritableChannelException expected) {
  }
  try {
    channel.write(new ByteBuffer[]{buffer("111"),buffer("111")});
    fail();
  }
 catch (  NonWritableChannelException expected) {
  }
  try {
    channel.write(new ByteBuffer[]{buffer("111"),buffer("111")},0,2);
    fail();
  }
 catch (  NonWritableChannelException expected) {
  }
  try {
    channel.transferFrom(new ByteBufferChannel(bytes("1111")),0,4);
    fail();
  }
 catch (  NonWritableChannelException expected) {
  }
  try {
    channel.truncate(0);
    fail();
  }
 catch (  NonWritableChannelException expected) {
  }
  try {
    channel.lock(0,10,false);
  }
 catch (  NonWritableChannelException expected) {
  }
}
