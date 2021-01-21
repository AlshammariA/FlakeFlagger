@Test public void testNonEmpty_read_partial_fromEnd_singleBuffer(){
  fillContent("2222222222");
  ByteBuffer buffer=ByteBuffer.allocate(3);
  assertEquals(2,store.read(8,buffer));
  assertBufferEquals("220",1,buffer);
}
