@Test public void testGetArray(){
  BitArray array=new BitArray(64);
  array.set(0);
  array.set(63);
  int[] ints=array.getBitArray();
  assertEquals(1,ints[0]);
  assertEquals(Integer.MIN_VALUE,ints[1]);
}
