@Test public void testDataMatrixImageWriter(){
  Map<EncodeHintType,Object> hints=new EnumMap<EncodeHintType,Object>(EncodeHintType.class);
  hints.put(EncodeHintType.DATA_MATRIX_SHAPE,SymbolShapeHint.FORCE_SQUARE);
  int bigEnough=64;
  DataMatrixWriter writer=new DataMatrixWriter();
  BitMatrix matrix=writer.encode("Hello Google",BarcodeFormat.DATA_MATRIX,bigEnough,bigEnough,hints);
  assertNotNull(matrix);
  assertTrue(bigEnough >= matrix.getWidth());
  assertTrue(bigEnough >= matrix.getHeight());
}
