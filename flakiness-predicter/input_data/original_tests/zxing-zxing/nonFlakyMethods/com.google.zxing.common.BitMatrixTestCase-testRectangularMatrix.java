@Test public void testRectangularMatrix(){
  BitMatrix matrix=new BitMatrix(75,20);
  assertEquals(75,matrix.getWidth());
  assertEquals(20,matrix.getHeight());
  matrix.set(10,0);
  matrix.set(11,1);
  matrix.set(50,2);
  matrix.set(51,3);
  matrix.flip(74,4);
  matrix.flip(0,5);
  assertTrue(matrix.get(10,0));
  assertTrue(matrix.get(11,1));
  assertTrue(matrix.get(50,2));
  assertTrue(matrix.get(51,3));
  assertTrue(matrix.get(74,4));
  assertTrue(matrix.get(0,5));
  matrix.flip(50,2);
  matrix.flip(51,3);
  assertFalse(matrix.get(50,2));
  assertFalse(matrix.get(51,3));
}
