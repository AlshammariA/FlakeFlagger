@Test public void testApplyMaskPenaltyRule2(){
  ByteMatrix matrix=new ByteMatrix(1,1);
  matrix.set(0,0,0);
  assertEquals(0,MaskUtil.applyMaskPenaltyRule2(matrix));
  matrix=new ByteMatrix(2,2);
  matrix.set(0,0,0);
  matrix.set(1,0,0);
  matrix.set(0,1,0);
  matrix.set(1,1,1);
  assertEquals(0,MaskUtil.applyMaskPenaltyRule2(matrix));
  matrix=new ByteMatrix(2,2);
  matrix.set(0,0,0);
  matrix.set(1,0,0);
  matrix.set(0,1,0);
  matrix.set(1,1,0);
  assertEquals(3,MaskUtil.applyMaskPenaltyRule2(matrix));
  matrix=new ByteMatrix(3,3);
  matrix.set(0,0,0);
  matrix.set(1,0,0);
  matrix.set(2,0,0);
  matrix.set(0,1,0);
  matrix.set(1,1,0);
  matrix.set(2,1,0);
  matrix.set(0,2,0);
  matrix.set(1,2,0);
  matrix.set(2,2,0);
  assertEquals(3 * 4,MaskUtil.applyMaskPenaltyRule2(matrix));
}
