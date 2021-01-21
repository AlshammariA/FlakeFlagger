@Test public void testNonEmpty_read_fromPastEnd_singleBuffer(){
  fillContent("123");
  ByteBuffer buffer=ByteBuffer.allocate(3);
  store.read(3,buffer);
  assertBufferEquals("000",3,buffer);
}
