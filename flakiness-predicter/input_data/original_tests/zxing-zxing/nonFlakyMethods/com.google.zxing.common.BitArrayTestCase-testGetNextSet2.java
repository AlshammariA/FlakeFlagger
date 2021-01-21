@Test public void testGetNextSet2(){
  BitArray array=new BitArray(33);
  array.set(31);
  for (int i=0; i < array.getSize(); i++) {
    assertEquals(String.valueOf(i),i <= 31 ? 31 : 33,array.getNextSet(i));
  }
  array=new BitArray(33);
  array.set(32);
  for (int i=0; i < array.getSize(); i++) {
    assertEquals(String.valueOf(i),32,array.getNextSet(i));
  }
}
