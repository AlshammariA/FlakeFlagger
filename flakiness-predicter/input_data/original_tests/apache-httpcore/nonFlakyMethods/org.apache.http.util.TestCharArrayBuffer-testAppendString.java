@Test public void testAppendString() throws Exception {
  CharArrayBuffer buffer=new CharArrayBuffer(8);
  buffer.append("stuff");
  buffer.append(" and more stuff");
  Assert.assertEquals("stuff and more stuff",buffer.toString());
}
