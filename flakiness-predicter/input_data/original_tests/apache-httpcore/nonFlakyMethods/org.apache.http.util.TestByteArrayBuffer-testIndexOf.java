@Test public void testIndexOf() throws Exception {
  final byte COLON=(byte)':';
  final byte COMMA=(byte)',';
  byte[] bytes="name1: value1; name2: value2".getBytes("US-ASCII");
  int index1=5;
  int index2=20;
  ByteArrayBuffer buffer=new ByteArrayBuffer(16);
  buffer.append(bytes,0,bytes.length);
  Assert.assertEquals(index1,buffer.indexOf(COLON));
  Assert.assertEquals(-1,buffer.indexOf(COMMA));
  Assert.assertEquals(index1,buffer.indexOf(COLON,-1,11));
  Assert.assertEquals(index1,buffer.indexOf(COLON,0,1000));
  Assert.assertEquals(-1,buffer.indexOf(COLON,2,1));
  Assert.assertEquals(index2,buffer.indexOf(COLON,index1 + 1,buffer.length()));
}
