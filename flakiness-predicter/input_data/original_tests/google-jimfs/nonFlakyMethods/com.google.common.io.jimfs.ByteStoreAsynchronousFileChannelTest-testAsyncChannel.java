/** 
 * Just tests the main read/write methods... the methods all delegate to the non-async channel anyway.
 */
@Test public void testAsyncChannel() throws Throwable {
  StubByteStore store=store(15);
  ExecutorService executor=Executors.newSingleThreadExecutor();
  ByteStoreAsynchronousFileChannel channel=channel(store,executor,READ,WRITE);
  try {
    assertEquals(15,channel.size());
    assertSame(channel,channel.truncate(5));
    assertEquals(5,channel.size());
    store.setSize(10);
    checkAsyncRead(channel);
    checkAsyncReadFailure(executor);
    checkAsyncWrite(channel);
    checkAsyncLock(channel);
    channel.close();
    assertFalse(channel.isOpen());
  }
  finally {
    executor.shutdown();
  }
}
