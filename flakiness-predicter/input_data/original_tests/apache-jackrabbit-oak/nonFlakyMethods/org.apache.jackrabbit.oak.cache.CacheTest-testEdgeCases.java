@Test public void testEdgeCases(){
  CacheLIRS<Integer,Integer> test=createCache(1);
  test.put(1,10,100);
  assertEquals(10,test.getUnchecked(1).intValue());
  try {
    test.put(null,10,100);
    fail();
  }
 catch (  NullPointerException e) {
  }
  try {
    test.put(1,null,100);
    fail();
  }
 catch (  NullPointerException e) {
  }
  try {
    test.setMaxMemory(0);
    fail();
  }
 catch (  IllegalArgumentException e) {
  }
  try {
    test.setAverageMemory(0);
    fail();
  }
 catch (  IllegalArgumentException e) {
  }
}
