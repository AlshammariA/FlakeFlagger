@Test public void testAppendSingleChar() throws Exception {
  CharArrayBuffer buffer=new CharArrayBuffer(4);
  buffer.append('1');
  buffer.append('2');
  buffer.append('3');
  buffer.append('4');
  buffer.append('5');
  buffer.append('6');
  Assert.assertEquals("123456",buffer.toString());
}
