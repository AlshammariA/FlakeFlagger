private static void testVarInt(int x,int expectedLen) throws IOException {
  ByteArrayOutputStream out=new ByteArrayOutputStream();
  IOUtils.writeVarInt(out,x);
  byte[] data=out.toByteArray();
  assertTrue(data.length <= 5);
  if (expectedLen > 0) {
    assertEquals(expectedLen,data.length);
  }
  ByteArrayInputStream in=new ByteArrayInputStream(data);
  int x2=IOUtils.readVarInt(in);
  assertEquals(x,x2);
  assertEquals(-1,in.read());
}
