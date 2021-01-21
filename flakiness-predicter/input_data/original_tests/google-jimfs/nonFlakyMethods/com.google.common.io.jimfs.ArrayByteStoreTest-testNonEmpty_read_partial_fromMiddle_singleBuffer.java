@Test public void testNonEmpty_read_partial_fromMiddle_singleBuffer(){
  fillContent("22223333");
  ByteBuffer buffer=ByteBuffer.allocate(3);
  assertEquals(3,store.read(3,buffer));
  assertBufferEquals("233",0,buffer);
}
