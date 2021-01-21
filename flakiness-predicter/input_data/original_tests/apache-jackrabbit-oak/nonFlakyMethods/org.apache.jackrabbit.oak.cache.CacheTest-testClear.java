@Test public void testClear(){
  CacheLIRS<Integer,Integer> test=createCache(40,10);
  for (int i=0; i < 5; i++) {
    test.put(i,10 * i,9);
  }
  verify(test,"mem: 36 stack: 4 3 2 1 cold: 4 non-resident: 0");
  for (  Entry<Integer,Integer> e : test.entrySet()) {
    assertTrue(e.getKey() >= 1 && e.getKey() <= 4);
    assertTrue(e.getValue() >= 10 && e.getValue() <= 40);
  }
  for (  int x : test.asMap().values()) {
    assertTrue(x >= 10 && x <= 40);
  }
  for (  int x : test.keySet()) {
    assertTrue(x >= 1 && x <= 4);
  }
  assertEquals(40,test.getMaxMemory());
  assertEquals(10,test.getAverageMemory());
  assertEquals(36,test.getUsedMemory());
  assertEquals(4,test.size());
  assertEquals(3,test.sizeHot());
  assertEquals(1,test.sizeNonResident());
  assertFalse(test.isEmpty());
  test.setMaxMemory(10);
  assertEquals(10,test.getMaxMemory());
  test.setMaxMemory(40);
  test.setAverageMemory(1);
  assertEquals(1,test.getAverageMemory());
  test.setAverageMemory(10);
  verify(test,"mem: 36 stack: 4 3 2 1 cold: 4 non-resident: 0");
  test.asMap().putAll(test.asMap());
  verify(test,"mem: 40 stack: 4 3 2 1 cold: non-resident: 0");
  test.clear();
  verify(test,"mem: 0 stack: cold: non-resident:");
  assertEquals(40,test.getMaxMemory());
  assertEquals(10,test.getAverageMemory());
  assertEquals(0,test.getUsedMemory());
  assertEquals(0,test.size());
  assertEquals(0,test.sizeHot());
  assertEquals(0,test.sizeNonResident());
  assertTrue(test.isEmpty());
}
