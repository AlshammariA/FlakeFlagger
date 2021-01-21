@Test public void testLock() throws IOException {
  ByteStoreFileChannel channel=channel(store(10),READ,WRITE);
  assertNotNull(channel.lock());
  assertNotNull(channel.lock(0,10,false));
  assertNotNull(channel.lock(0,10,true));
  assertNotNull(channel.tryLock());
  assertNotNull(channel.tryLock(0,10,false));
  assertNotNull(channel.tryLock(0,10,true));
  FileLock lock=channel.lock();
  assertTrue(lock.isValid());
  lock.release();
  assertFalse(lock.isValid());
}
