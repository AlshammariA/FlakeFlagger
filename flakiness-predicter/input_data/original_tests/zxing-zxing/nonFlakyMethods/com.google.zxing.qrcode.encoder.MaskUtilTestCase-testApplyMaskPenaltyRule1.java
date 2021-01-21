@Test public void testApplyMaskPenaltyRule1(){
  ByteMatrix matrix=new ByteMatrix(4,1);
  matrix.set(0,0,0);
  matrix.set(1,0,0);
  matrix.set(2,0,0);
  matrix.set(3,0,0);
  assertEquals(0,MaskUtil.applyMaskPenaltyRule1(matrix));
  matrix=new ByteMatrix(6,1);
  matrix.set(0,0,0);
  matrix.set(1,0,0);
  matrix.set(2,0,0);
  matrix.set(3,0,0);
  matrix.set(4,0,0);
  matrix.set(5,0,1);
  assertEquals(3,MaskUtil.applyMaskPenaltyRule1(matrix));
  matrix.set(5,0,0);
  assertEquals(4,MaskUtil.applyMaskPenaltyRule1(matrix));
  matrix=new ByteMatrix(1,6);
  matrix.set(0,0,0);
  matrix.set(0,1,0);
  matrix.set(0,2,0);
  matrix.set(0,3,0);
  matrix.set(0,4,0);
  matrix.set(0,5,1);
  assertEquals(3,MaskUtil.applyMaskPenaltyRule1(matrix));
  matrix.set(0,5,0);
  assertEquals(4,MaskUtil.applyMaskPenaltyRule1(matrix));
}
