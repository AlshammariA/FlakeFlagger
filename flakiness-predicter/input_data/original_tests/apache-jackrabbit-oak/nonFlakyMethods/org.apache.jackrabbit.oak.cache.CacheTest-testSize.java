@Test public void testSize(){
  verifyMapSize(7,16);
  verifyMapSize(13,32);
  verifyMapSize(25,64);
  verifyMapSize(49,128);
  verifyMapSize(97,256);
  verifyMapSize(193,512);
  verifyMapSize(385,1024);
  verifyMapSize(769,2048);
  CacheLIRS<Integer,Integer> test;
  test=createCache(3,10);
  test.put(0,0,9);
  test.put(1,10,9);
  test.put(2,20,9);
  test.put(3,30,9);
  test.put(4,40,9);
  test=createCache(1,1);
  test.put(1,10);
  test.put(0,0);
  test.getUnchecked(0);
  test=createCache(1000);
  for (int j=0; j < 2000; j++) {
    test.put(j,j);
  }
  assertEquals(62,test.size() - test.sizeHot());
  assertEquals(968,test.sizeNonResident());
}
