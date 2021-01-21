@Test public void testGetNextSet3(){
  BitArray array=new BitArray(63);
  array.set(31);
  array.set(32);
  for (int i=0; i < array.getSize(); i++) {
    int expected;
    if (i <= 31) {
      expected=31;
    }
 else     if (i == 32) {
      expected=32;
    }
 else {
      expected=63;
    }
    assertEquals(String.valueOf(i),expected,array.getNextSet(i));
  }
}
