@Test public void testAppendNullByteArray() throws Exception {
  CharArrayBuffer buffer=new CharArrayBuffer(8);
  buffer.append((byte[])null,0,0);
  Assert.assertEquals("",buffer.toString());
}
