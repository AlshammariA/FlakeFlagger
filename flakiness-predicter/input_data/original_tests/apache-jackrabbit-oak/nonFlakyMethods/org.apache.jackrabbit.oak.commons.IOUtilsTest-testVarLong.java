public void testVarLong() throws IOException {
  testVarLong(0,1);
  testVarLong(0x7f,1);
  testVarLong(0x80,2);
  testVarLong(0x3fff,2);
  testVarLong(0x4000,3);
  testVarLong(0x1fffff,3);
  testVarLong(0x200000,4);
  testVarLong(0xfffffff,4);
  testVarLong(0x10000000,5);
  testVarLong(0x1fffffffL,5);
  testVarLong(0x2000000000L,6);
  testVarLong(0x3ffffffffffL,6);
  testVarLong(0x40000000000L,7);
  testVarLong(0x1ffffffffffffL,7);
  testVarLong(0x2000000000000L,8);
  testVarLong(0xffffffffffffffL,8);
  testVarLong(0x100000000000000L,9);
  testVarLong(-1,10);
  for (int x=0; x < 0x20000; x++) {
    testVarLong(x,0);
    testVarLong(Long.MIN_VALUE + x,0);
    testVarLong(Long.MAX_VALUE - x,9);
    testVarLong(0x200000 + x - 100,0);
    testVarLong(0x10000000 + x - 100,0);
  }
  Random r=new Random(1);
  for (int i=0; i < 100000; i++) {
    testVarLong(r.nextLong(),0);
    testVarLong(r.nextInt(Integer.MAX_VALUE),0);
  }
  InputStream in=new ByteArrayInputStream(new byte[]{(byte)0x80,0});
  assertEquals(0,IOUtils.readVarLong(in));
  assertEquals(-1,in.read());
}
