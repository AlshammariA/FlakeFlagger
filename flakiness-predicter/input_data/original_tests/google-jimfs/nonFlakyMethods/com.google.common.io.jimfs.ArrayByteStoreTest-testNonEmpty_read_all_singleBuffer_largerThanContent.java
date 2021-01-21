@Test public void testNonEmpty_read_all_singleBuffer_largerThanContent(){
  fillContent("222222");
  ByteBuffer buffer=ByteBuffer.allocate(16);
  assertBufferEquals("0000000000000000",16,buffer);
  assertEquals(6,store.read(0,buffer));
  assertBufferEquals("2222220000000000",10,buffer);
}
