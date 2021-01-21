@Test public void testNonEmpty_read_partial_fromStart_singleBuffer(){
  fillContent("222222");
  ByteBuffer buffer=ByteBuffer.allocate(3);
  assertEquals(3,store.read(0,buffer));
  assertBufferEquals("222",0,buffer);
}
