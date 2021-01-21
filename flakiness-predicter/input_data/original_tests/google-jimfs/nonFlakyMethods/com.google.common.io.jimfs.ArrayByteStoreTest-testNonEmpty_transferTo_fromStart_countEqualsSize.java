@Test public void testNonEmpty_transferTo_fromStart_countEqualsSize() throws IOException {
  fillContent("123456");
  ByteBufferChannel channel=new ByteBufferChannel(10);
  assertEquals(6,store.transferTo(0,6,channel));
  assertBufferEquals("1234560000",4,channel.buffer());
}
