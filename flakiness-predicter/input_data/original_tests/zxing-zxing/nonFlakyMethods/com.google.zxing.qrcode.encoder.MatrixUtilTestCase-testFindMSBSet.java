@Test public void testFindMSBSet(){
  assertEquals(0,MatrixUtil.findMSBSet(0));
  assertEquals(1,MatrixUtil.findMSBSet(1));
  assertEquals(8,MatrixUtil.findMSBSet(0x80));
  assertEquals(32,MatrixUtil.findMSBSet(0x80000000));
}
