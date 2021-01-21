@Test public void testLimitHot(){
  CacheLIRS<Integer,Integer> test=createCache(100);
  for (int i=0; i < 300; i++) {
    test.put(i,10 * i);
  }
  assertEquals(100,test.size());
  assertEquals(99,test.sizeNonResident());
  assertEquals(93,test.sizeHot());
}
