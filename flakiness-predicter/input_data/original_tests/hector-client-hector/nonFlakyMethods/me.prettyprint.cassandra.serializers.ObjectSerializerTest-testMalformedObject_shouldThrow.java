@Test(expected=HectorSerializationException.class) public void testMalformedObject_shouldThrow(){
  ObjectSerializer ser=ObjectSerializer.get();
  ser.fromByteBuffer(ByteBuffer.wrap(new byte[]{1,2,3}));
}
