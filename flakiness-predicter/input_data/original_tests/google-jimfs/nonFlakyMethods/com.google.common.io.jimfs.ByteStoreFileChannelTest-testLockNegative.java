@Test public void testLockNegative() throws IOException {
  ByteStoreFileChannel channel=channel(store(0),READ,WRITE);
  try {
    channel.lock(-1,10,true);
    fail();
  }
 catch (  IllegalArgumentException expected) {
  }
  try {
    channel.lock(0,-1,true);
    fail();
  }
 catch (  IllegalArgumentException expected) {
  }
  try {
    channel.tryLock(-1,10,true);
    fail();
  }
 catch (  IllegalArgumentException expected) {
  }
  try {
    channel.tryLock(0,-1,true);
    fail();
  }
 catch (  IllegalArgumentException expected) {
  }
}
