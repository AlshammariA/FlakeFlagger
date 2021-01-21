@Test public void testDataMatrixWriter(){
  Map<EncodeHintType,Object> hints=new EnumMap<EncodeHintType,Object>(EncodeHintType.class);
  hints.put(EncodeHintType.DATA_MATRIX_SHAPE,SymbolShapeHint.FORCE_SQUARE);
  int bigEnough=14;
  DataMatrixWriter writer=new DataMatrixWriter();
  BitMatrix matrix=writer.encode("Hello Me",BarcodeFormat.DATA_MATRIX,bigEnough,bigEnough,hints);
  assertNotNull(matrix);
  assertEquals(bigEnough,matrix.getWidth());
  assertEquals(bigEnough,matrix.getHeight());
}
