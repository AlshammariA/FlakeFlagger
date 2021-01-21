@Test public void testEnsureCapacity() throws Exception {
  ByteArrayBuffer buffer=new ByteArrayBuffer(4);
  buffer.ensureCapacity(2);
  Assert.assertEquals(4,buffer.capacity());
  buffer.ensureCapacity(8);
  Assert.assertEquals(8,buffer.capacity());
}
