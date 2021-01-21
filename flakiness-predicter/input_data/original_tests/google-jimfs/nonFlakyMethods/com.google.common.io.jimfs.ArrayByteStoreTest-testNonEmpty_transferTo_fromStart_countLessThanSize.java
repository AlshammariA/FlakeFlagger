@Test public void testNonEmpty_transferTo_fromStart_countLessThanSize() throws IOException {
  fillContent("123456");
  ByteBufferChannel channel=new ByteBufferChannel(10);
  assertEquals(4,store.transferTo(0,4,channel));
  assertBufferEquals("1234000000",6,channel.buffer());
}
