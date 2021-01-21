@Test public void testGetNextSet4(){
  BitArray array=new BitArray(63);
  array.set(33);
  array.set(40);
  for (int i=0; i < array.getSize(); i++) {
    int expected;
    if (i <= 33) {
      expected=33;
    }
 else     if (i <= 40) {
      expected=40;
    }
 else {
      expected=63;
    }
    assertEquals(String.valueOf(i),expected,array.getNextSet(i));
  }
}
