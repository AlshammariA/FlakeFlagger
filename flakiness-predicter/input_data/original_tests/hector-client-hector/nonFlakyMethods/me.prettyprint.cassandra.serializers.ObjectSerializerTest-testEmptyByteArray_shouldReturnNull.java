@Test public void testEmptyByteArray_shouldReturnNull(){
  ObjectSerializer ser=ObjectSerializer.get();
  assertNull("An empty byte array should be translated to null",ser.fromByteBuffer(ByteBuffer.wrap(new byte[0])));
}
