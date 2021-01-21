@Test public void testIsRange(){
  BitArray array=new BitArray(64);
  assertTrue(array.isRange(0,64,false));
  assertFalse(array.isRange(0,64,true));
  array.set(32);
  assertTrue(array.isRange(32,33,true));
  array.set(31);
  assertTrue(array.isRange(31,33,true));
  array.set(34);
  assertFalse(array.isRange(31,35,true));
  for (int i=0; i < 31; i++) {
    array.set(i);
  }
  assertTrue(array.isRange(0,33,true));
  for (int i=33; i < 64; i++) {
    array.set(i);
  }
  assertTrue(array.isRange(0,64,true));
  assertFalse(array.isRange(0,64,false));
}
