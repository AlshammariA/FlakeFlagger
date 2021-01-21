@Test public void testNonEmpty_transferTo_fromMiddle_countEqualsSize() throws IOException {
  fillContent("123456");
  ByteBufferChannel channel=new ByteBufferChannel(10);
  assertEquals(2,store.transferTo(4,6,channel));
  assertBufferEquals("5600000000",8,channel.buffer());
}
