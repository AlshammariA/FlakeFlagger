@Test public void testNonEmpty_read_all_multipleBuffers_largerThanContent(){
  fillContent("222222");
  ByteBuffer buf1=ByteBuffer.allocate(4);
  ByteBuffer buf2=ByteBuffer.allocate(8);
  assertEquals(6,store.read(0,ImmutableList.of(buf1,buf2)));
  assertBufferEquals("2222",0,buf1);
  assertBufferEquals("22000000",6,buf2);
}
