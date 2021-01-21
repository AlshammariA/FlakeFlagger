@Test public void testNonEmpty_read_partial_fromEnd_multipleBuffers(){
  fillContent("123456789");
  ByteBuffer buf1=ByteBuffer.allocate(2);
  ByteBuffer buf2=ByteBuffer.allocate(2);
  assertEquals(3,store.read(6,ImmutableList.of(buf1,buf2)));
  assertBufferEquals("78",0,buf1);
  assertBufferEquals("90",1,buf2);
}
