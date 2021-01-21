@Test public void testSimpleAppend() throws Exception {
  CharArrayBuffer buffer=new CharArrayBuffer(16);
  Assert.assertEquals(16,buffer.capacity());
  Assert.assertEquals(0,buffer.length());
  char[] b1=buffer.toCharArray();
  Assert.assertNotNull(b1);
  Assert.assertEquals(0,b1.length);
  Assert.assertTrue(buffer.isEmpty());
  Assert.assertFalse(buffer.isFull());
  char[] tmp=new char[]{'1','2','3','4'};
  buffer.append(tmp,0,tmp.length);
  Assert.assertEquals(16,buffer.capacity());
  Assert.assertEquals(4,buffer.length());
  Assert.assertFalse(buffer.isEmpty());
  Assert.assertFalse(buffer.isFull());
  char[] b2=buffer.toCharArray();
  Assert.assertNotNull(b2);
  Assert.assertEquals(4,b2.length);
  for (int i=0; i < tmp.length; i++) {
    Assert.assertEquals(tmp[i],b2[i]);
    Assert.assertEquals(tmp[i],buffer.charAt(i));
  }
  Assert.assertEquals("1234",buffer.toString());
  buffer.clear();
  Assert.assertEquals(16,buffer.capacity());
  Assert.assertEquals(0,buffer.length());
  Assert.assertTrue(buffer.isEmpty());
  Assert.assertFalse(buffer.isFull());
}
