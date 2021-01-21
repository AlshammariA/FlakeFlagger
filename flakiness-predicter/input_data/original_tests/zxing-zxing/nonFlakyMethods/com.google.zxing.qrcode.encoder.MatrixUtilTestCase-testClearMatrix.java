@Test public void testClearMatrix(){
  ByteMatrix matrix=new ByteMatrix(2,2);
  MatrixUtil.clearMatrix(matrix);
  assertEquals(-1,matrix.get(0,0));
  assertEquals(-1,matrix.get(1,0));
  assertEquals(-1,matrix.get(0,1));
  assertEquals(-1,matrix.get(1,1));
}
