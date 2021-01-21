@Test public void testNonEmpty_transferFrom_toMiddle_transferGoesBeyondContentSize() throws IOException {
  fillContent("222222");
  ByteBufferChannel channel=new ByteBufferChannel(buffer("111111"));
  assertEquals(6,store.transferFrom(channel,4,6));
  assertContentEquals("2222111111",store);
}
