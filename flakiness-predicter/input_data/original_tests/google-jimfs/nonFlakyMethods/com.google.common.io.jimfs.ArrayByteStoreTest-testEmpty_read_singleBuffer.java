@Test public void testEmpty_read_singleBuffer(){
  ByteBuffer buffer=ByteBuffer.allocate(10);
  int read=store.read(0,buffer);
  assertEquals(-1,read);
  assertEquals(0,buffer.position());
}
