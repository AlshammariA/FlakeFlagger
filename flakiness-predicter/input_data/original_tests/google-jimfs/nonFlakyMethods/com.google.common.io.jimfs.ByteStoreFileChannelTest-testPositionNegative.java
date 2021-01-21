@Test public void testPositionNegative() throws IOException {
  ByteStoreFileChannel channel=channel(store(0),READ,WRITE);
  try {
    channel.position(-1);
    fail();
  }
 catch (  IllegalArgumentException expected) {
  }
}
