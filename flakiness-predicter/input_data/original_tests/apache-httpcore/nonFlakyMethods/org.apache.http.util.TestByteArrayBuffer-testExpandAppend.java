@Test public void testExpandAppend() throws Exception {
  ByteArrayBuffer buffer=new ByteArrayBuffer(4);
  Assert.assertEquals(4,buffer.capacity());
  byte[] tmp=new byte[]{1,2,3,4};
  buffer.append(tmp,0,2);
  buffer.append(tmp,0,4);
  buffer.append(tmp,0,0);
  Assert.assertEquals(8,buffer.capacity());
  Assert.assertEquals(6,buffer.length());
  buffer.append(tmp,0,4);
  Assert.assertEquals(16,buffer.capacity());
  Assert.assertEquals(10,buffer.length());
}
