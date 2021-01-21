public void testBackgroundEvictionThread() throws Exception {
  long maxSize=100000;
  long blockSize=calculateBlockSizeDefault(maxSize,9);
  LruBlockCache cache=new LruBlockCache(maxSize,blockSize);
  Block[] blocks=generateFixedBlocks(10,blockSize,"block");
  for (  Block block : blocks) {
    cache.cacheBlock(block.blockName,block.buf);
  }
  int n=0;
  while (cache.getEvictionCount() == 0) {
    System.out.println("sleep");
    Thread.sleep(1000);
    assertTrue(n++ < 2);
  }
  System.out.println("Background Evictions run: " + cache.getEvictionCount());
  assertEquals(cache.getEvictionCount(),1);
}
