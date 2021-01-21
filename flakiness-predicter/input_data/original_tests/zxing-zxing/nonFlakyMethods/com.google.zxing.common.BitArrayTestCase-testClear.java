@Test public void testClear(){
  BitArray array=new BitArray(32);
  for (int i=0; i < 32; i++) {
    array.set(i);
  }
  array.clear();
  for (int i=0; i < 32; i++) {
    assertFalse(array.get(i));
  }
}
