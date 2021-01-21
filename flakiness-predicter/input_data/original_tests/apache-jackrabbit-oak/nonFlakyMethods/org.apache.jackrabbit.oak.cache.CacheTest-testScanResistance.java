@Test public void testScanResistance(){
  boolean log=false;
  int size=20;
  CacheLIRS<Integer,Integer> test=createCache(size / 2 + 1);
  for (int i=0; i < size; i++) {
    test.put(-i,-i * 10);
  }
  verify(test,null);
  for (int i=0; i < size / 2; i++) {
    test.put(i,i * 10);
    test.getUnchecked(i);
    if (log) {
      System.out.println("get " + i + " -> "+ test);
    }
  }
  verify(test,null);
  for (int i=0; i < size; i++) {
    Integer x=test.getIfPresent(i);
    Integer y=test.peek(i);
    if (i < size / 2) {
      assertTrue("i: " + i,x != null);
      assertTrue("i: " + i,y != null);
      assertEquals(i * 10,x.intValue());
      assertEquals(i * 10,y.intValue());
    }
 else {
      assertNull(x);
      assertNull(y);
      test.put(i,i * 10);
      assertEquals(i * 10,test.peek(i).intValue());
    }
    if (log) {
      System.out.println("get " + i + " -> "+ test);
    }
    verify(test,null);
  }
  for (int i=0; i < size; i++) {
    Integer x=test.getIfPresent(i);
    if (i < size / 2 || i == size - 1) {
      assertTrue("i: " + i,x != null);
      assertEquals(i * 10,x.intValue());
    }
 else {
      assertNull(x);
    }
    verify(test,null);
  }
}
