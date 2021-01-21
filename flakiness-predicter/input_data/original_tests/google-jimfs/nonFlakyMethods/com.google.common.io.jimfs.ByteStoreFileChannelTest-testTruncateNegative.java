@Test public void testTruncateNegative() throws IOException {
  ByteStoreFileChannel channel=channel(store(0),READ,WRITE);
  try {
    channel.truncate(-1);
    fail();
  }
 catch (  IllegalArgumentException expected) {
  }
}
