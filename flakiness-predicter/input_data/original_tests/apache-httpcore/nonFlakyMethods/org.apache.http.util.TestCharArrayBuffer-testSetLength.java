@Test public void testSetLength() throws Exception {
  CharArrayBuffer buffer=new CharArrayBuffer(4);
  buffer.setLength(2);
  Assert.assertEquals(2,buffer.length());
}
