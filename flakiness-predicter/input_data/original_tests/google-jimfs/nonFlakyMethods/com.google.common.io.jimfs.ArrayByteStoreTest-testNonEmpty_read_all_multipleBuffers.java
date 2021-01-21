@Test public void testNonEmpty_read_all_multipleBuffers(){
  fillContent("223334");
  ByteBuffer buf1=ByteBuffer.allocate(3);
  ByteBuffer buf2=ByteBuffer.allocate(3);
  assertEquals(6,store.read(0,ImmutableList.of(buf1,buf2)));
  assertBufferEquals("223",0,buf1);
  assertBufferEquals("334",0,buf2);
}
