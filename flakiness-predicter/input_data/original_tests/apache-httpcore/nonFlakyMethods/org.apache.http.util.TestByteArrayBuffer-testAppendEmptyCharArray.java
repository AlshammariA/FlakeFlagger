@Test public void testAppendEmptyCharArray() throws Exception {
  ByteArrayBuffer buffer=new ByteArrayBuffer(8);
  buffer.append(new char[]{},0,0);
  Assert.assertEquals(0,buffer.length());
}
