@Test public void testGetNextSet1(){
  BitArray array=new BitArray(32);
  for (int i=0; i < array.getSize(); i++) {
    assertEquals(String.valueOf(i),32,array.getNextSet(i));
  }
  array=new BitArray(33);
  for (int i=0; i < array.getSize(); i++) {
    assertEquals(String.valueOf(i),33,array.getNextSet(i));
  }
}
