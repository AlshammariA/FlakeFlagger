@Test public void testSetRegion(){
  BitMatrix matrix=new BitMatrix(5);
  matrix.setRegion(1,1,3,3);
  for (int y=0; y < 5; y++) {
    for (int x=0; x < 5; x++) {
      assertEquals(y >= 1 && y <= 3 && x >= 1 && x <= 3,matrix.get(x,y));
    }
  }
}
