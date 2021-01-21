@Test public void testNonEmpty_transferTo_fromMiddle_countLessThanSize() throws IOException {
  fillContent("12345678");
  ByteBufferChannel channel=new ByteBufferChannel(10);
  assertEquals(4,store.transferTo(3,4,channel));
  assertBufferEquals("4567000000",6,channel.buffer());
}
