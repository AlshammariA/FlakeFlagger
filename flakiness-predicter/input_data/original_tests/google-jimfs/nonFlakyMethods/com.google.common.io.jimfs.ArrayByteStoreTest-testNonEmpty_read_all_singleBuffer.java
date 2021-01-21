@Test public void testNonEmpty_read_all_singleBuffer(){
  fillContent("222222");
  ByteBuffer buffer=ByteBuffer.allocate(6);
  assertEquals(6,store.read(0,buffer));
  assertBufferEquals("222222",0,buffer);
}
