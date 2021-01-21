@Test public void testPruneStack(){
  CacheLIRS<Integer,Integer> test=createCache(5);
  for (int i=0; i < 7; i++) {
    test.put(i,i * 10);
  }
  verify(test,"mem: 5 stack: 6 5 4 3 2 1 cold: 6 non-resident: 5 0");
  test.getUnchecked(4);
  test.getUnchecked(3);
  test.getUnchecked(2);
  verify(test,"mem: 5 stack: 2 3 4 6 5 1 cold: 6 non-resident: 5 0");
  test.remove(1);
  verify(test,"mem: 4 stack: 2 3 4 6 cold: non-resident: 5 0");
  test.put(0,0);
  test.put(1,10);
  verify(test,"mem: 5 stack: 1 0 2 3 4 cold: 1 non-resident: 6 5");
}
