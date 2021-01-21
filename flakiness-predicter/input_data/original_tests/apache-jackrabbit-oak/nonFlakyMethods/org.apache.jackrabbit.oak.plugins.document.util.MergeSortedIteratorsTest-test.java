@SuppressWarnings("unchecked") @Test public void test(){
  assertEquals(list(),sort());
  assertEquals(list(),sort(list()));
  assertEquals(list(1,2,3,4),sort(list(1,2),list(3,4)));
  assertEquals(list(1,2,3,4),sort(list(1,3),list(2,4)));
  assertEquals(list(1,2,3),sort(list(1,3),list(2)));
  assertEquals(list(1,2,3,4),sort(list(1,4),list(2,3)));
  assertEquals(list(1,2,3,4,5,6),sort(list(1,5),list(2,4),list(3,6)));
}
