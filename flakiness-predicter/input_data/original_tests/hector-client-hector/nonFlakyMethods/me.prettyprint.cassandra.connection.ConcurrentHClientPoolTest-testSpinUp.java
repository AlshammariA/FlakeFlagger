@Test public void testSpinUp(){
  assertEquals(16,clientPool.getNumIdle());
  assertEquals(50,clientPool.getNumBeforeExhausted());
  assertEquals(0,clientPool.getNumBlockedThreads());
  assertEquals(0,clientPool.getNumActive());
}
