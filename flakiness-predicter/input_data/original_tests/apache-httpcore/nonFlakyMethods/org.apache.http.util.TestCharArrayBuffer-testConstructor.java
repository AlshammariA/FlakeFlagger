@Test public void testConstructor() throws Exception {
  CharArrayBuffer buffer=new CharArrayBuffer(16);
  Assert.assertEquals(16,buffer.capacity());
  Assert.assertEquals(0,buffer.length());
  Assert.assertNotNull(buffer.buffer());
  Assert.assertEquals(16,buffer.buffer().length);
  try {
    new CharArrayBuffer(-1);
    Assert.fail("IllegalArgumentException should have been thrown");
  }
 catch (  IllegalArgumentException ex) {
  }
}
