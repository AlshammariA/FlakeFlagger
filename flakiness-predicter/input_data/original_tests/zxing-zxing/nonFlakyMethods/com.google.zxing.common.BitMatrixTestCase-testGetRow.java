@Test public void testGetRow(){
  BitMatrix matrix=new BitMatrix(102,5);
  for (int x=0; x < 102; x++) {
    if ((x & 0x03) == 0) {
      matrix.set(x,2);
    }
  }
  BitArray array=matrix.getRow(2,null);
  assertEquals(102,array.getSize());
  BitArray array2=new BitArray(60);
  array2=matrix.getRow(2,array2);
  assertEquals(102,array2.getSize());
  BitArray array3=new BitArray(200);
  array3=matrix.getRow(2,array3);
  assertEquals(200,array3.getSize());
  for (int x=0; x < 102; x++) {
    boolean on=(x & 0x03) == 0;
    assertEquals(on,array.get(x));
    assertEquals(on,array2.get(x));
    assertEquals(on,array3.get(x));
  }
}
