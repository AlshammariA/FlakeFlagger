@Test public void testAppendNullCharArrayBuffer() throws Exception {
  ByteArrayBuffer buffer=new ByteArrayBuffer(8);
  buffer.append((CharArrayBuffer)null,0,0);
  Assert.assertEquals(0,buffer.length());
}
