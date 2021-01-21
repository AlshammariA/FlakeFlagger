@Test public void testGetSet(){
  BitMatrix matrix=new BitMatrix(33);
  assertEquals(33,matrix.getHeight());
  for (int y=0; y < 33; y++) {
    for (int x=0; x < 33; x++) {
      if (y * x % 3 == 0) {
        matrix.set(x,y);
      }
    }
  }
  for (int y=0; y < 33; y++) {
    for (int x=0; x < 33; x++) {
      assertEquals(y * x % 3 == 0,matrix.get(x,y));
    }
  }
}
