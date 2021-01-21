@Test public void testSymbolInfo(){
  SymbolInfo info=SymbolInfo.lookup(3);
  assertEquals(5,info.getErrorCodewords());
  assertEquals(8,info.matrixWidth);
  assertEquals(8,info.matrixHeight);
  assertEquals(10,info.getSymbolWidth());
  assertEquals(10,info.getSymbolHeight());
  info=SymbolInfo.lookup(3,SymbolShapeHint.FORCE_RECTANGLE);
  assertEquals(7,info.getErrorCodewords());
  assertEquals(16,info.matrixWidth);
  assertEquals(6,info.matrixHeight);
  assertEquals(18,info.getSymbolWidth());
  assertEquals(8,info.getSymbolHeight());
  info=SymbolInfo.lookup(9);
  assertEquals(11,info.getErrorCodewords());
  assertEquals(14,info.matrixWidth);
  assertEquals(6,info.matrixHeight);
  assertEquals(32,info.getSymbolWidth());
  assertEquals(8,info.getSymbolHeight());
  info=SymbolInfo.lookup(9,SymbolShapeHint.FORCE_SQUARE);
  assertEquals(12,info.getErrorCodewords());
  assertEquals(14,info.matrixWidth);
  assertEquals(14,info.matrixHeight);
  assertEquals(16,info.getSymbolWidth());
  assertEquals(16,info.getSymbolHeight());
  try {
    SymbolInfo.lookup(1559);
    fail("There's no rectangular symbol for more than 1558 data codewords");
  }
 catch (  IllegalArgumentException iae) {
  }
  try {
    SymbolInfo.lookup(50,SymbolShapeHint.FORCE_RECTANGLE);
    fail("There's no rectangular symbol for 50 data codewords");
  }
 catch (  IllegalArgumentException iae) {
  }
  info=SymbolInfo.lookup(35);
  assertEquals(24,info.getSymbolWidth());
  assertEquals(24,info.getSymbolHeight());
  Dimension fixedSize=new Dimension(26,26);
  info=SymbolInfo.lookup(35,SymbolShapeHint.FORCE_NONE,fixedSize,fixedSize,false);
  assertEquals(26,info.getSymbolWidth());
  assertEquals(26,info.getSymbolHeight());
  info=SymbolInfo.lookup(45,SymbolShapeHint.FORCE_NONE,fixedSize,fixedSize,false);
  assertNull(info);
  Dimension minSize=fixedSize;
  Dimension maxSize=new Dimension(32,32);
  info=SymbolInfo.lookup(35,SymbolShapeHint.FORCE_NONE,minSize,maxSize,false);
  assertEquals(26,info.getSymbolWidth());
  assertEquals(26,info.getSymbolHeight());
  info=SymbolInfo.lookup(40,SymbolShapeHint.FORCE_NONE,minSize,maxSize,false);
  assertEquals(26,info.getSymbolWidth());
  assertEquals(26,info.getSymbolHeight());
  info=SymbolInfo.lookup(45,SymbolShapeHint.FORCE_NONE,minSize,maxSize,false);
  assertEquals(32,info.getSymbolWidth());
  assertEquals(32,info.getSymbolHeight());
  info=SymbolInfo.lookup(63,SymbolShapeHint.FORCE_NONE,minSize,maxSize,false);
  assertNull(info);
}
