@Test public void testSetBulk(){
  BitArray array=new BitArray(64);
  array.setBulk(32,0xFFFF0000);
  for (int i=0; i < 48; i++) {
    assertFalse(array.get(i));
  }
  for (int i=48; i < 64; i++) {
    assertTrue(array.get(i));
  }
}
