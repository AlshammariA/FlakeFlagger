@Test public void testRectangularSetRegion(){
  BitMatrix matrix=new BitMatrix(320,240);
  assertEquals(320,matrix.getWidth());
  assertEquals(240,matrix.getHeight());
  matrix.setRegion(105,22,80,12);
  for (int y=0; y < 240; y++) {
    for (int x=0; x < 320; x++) {
      assertEquals(y >= 22 && y < 34 && x >= 105 && x < 185,matrix.get(x,y));
    }
  }
}
