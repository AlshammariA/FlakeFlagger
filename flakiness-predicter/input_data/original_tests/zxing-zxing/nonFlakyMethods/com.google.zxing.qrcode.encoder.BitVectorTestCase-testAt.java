@Test public void testAt(){
  BitArray v=new BitArray();
  v.appendBits(0xdead,16);
  assertTrue(v.get(0));
  assertTrue(v.get(1));
  assertFalse(v.get(2));
  assertTrue(v.get(3));
  assertTrue(v.get(4));
  assertTrue(v.get(5));
  assertTrue(v.get(6));
  assertFalse(v.get(7));
  assertTrue(v.get(8));
  assertFalse(v.get(9));
  assertTrue(v.get(10));
  assertFalse(v.get(11));
  assertTrue(v.get(12));
  assertTrue(v.get(13));
  assertFalse(v.get(14));
  assertTrue(v.get(15));
}
