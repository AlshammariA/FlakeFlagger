@Test public void testNonEmpty_read_partial_fromMiddle_multipleBuffers(){
  fillContent("12345678");
  ByteBuffer buf1=ByteBuffer.allocate(2);
  ByteBuffer buf2=ByteBuffer.allocate(2);
  assertEquals(4,store.read(3,ImmutableList.of(buf1,buf2)));
  assertBufferEquals("45",0,buf1);
  assertBufferEquals("67",0,buf2);
}
