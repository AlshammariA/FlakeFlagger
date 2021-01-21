@Test public void testEnsureCapacity() throws Exception {
  CharArrayBuffer buffer=new CharArrayBuffer(4);
  buffer.ensureCapacity(2);
  Assert.assertEquals(4,buffer.capacity());
  buffer.ensureCapacity(8);
  Assert.assertEquals(8,buffer.capacity());
}
