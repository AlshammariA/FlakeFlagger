@Test public void testGetSet(){
  BitArray array=new BitArray(33);
  for (int i=0; i < 33; i++) {
    assertFalse(array.get(i));
    array.set(i);
    assertTrue(array.get(i));
  }
}
