@Test public void testLimitNonResident(){
  CacheLIRS<Integer,Integer> test=createCache(4);
  for (int i=0; i < 20; i++) {
    test.put(i,10 * i);
  }
  verify(test,"mem: 4 stack: 19 18 17 16 3 2 1 cold: 19 non-resident: 18 17 16");
}
