@Test public void testNonEmpty_read_fromPastEnd_multipleBuffers(){
  fillContent("123");
  ByteBuffer buf1=ByteBuffer.allocate(2);
  ByteBuffer buf2=ByteBuffer.allocate(2);
  assertEquals(-1,store.read(6,ImmutableList.of(buf1,buf2)));
  assertBufferEquals("00",2,buf1);
  assertBufferEquals("00",2,buf2);
}
