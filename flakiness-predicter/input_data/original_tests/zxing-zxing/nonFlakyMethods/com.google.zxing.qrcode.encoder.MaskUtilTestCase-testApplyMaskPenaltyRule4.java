@Test public void testApplyMaskPenaltyRule4(){
  ByteMatrix matrix=new ByteMatrix(1,1);
  matrix.set(0,0,0);
  assertEquals(100,MaskUtil.applyMaskPenaltyRule4(matrix));
  matrix=new ByteMatrix(2,1);
  matrix.set(0,0,0);
  matrix.set(0,0,1);
  assertEquals(0,MaskUtil.applyMaskPenaltyRule4(matrix));
  matrix=new ByteMatrix(6,1);
  matrix.set(0,0,0);
  matrix.set(1,0,1);
  matrix.set(2,0,1);
  matrix.set(3,0,1);
  matrix.set(4,0,1);
  matrix.set(5,0,0);
  assertEquals(30,MaskUtil.applyMaskPenaltyRule4(matrix));
}
