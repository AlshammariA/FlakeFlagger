@Test public void testEmpty_read_multipleBuffers(){
  ByteBuffer buf1=ByteBuffer.allocate(5);
  ByteBuffer buf2=ByteBuffer.allocate(5);
  int read=store.read(0,ImmutableList.of(buf1,buf2));
  assertEquals(-1,read);
  assertEquals(0,buf1.position());
  assertEquals(0,buf2.position());
}
