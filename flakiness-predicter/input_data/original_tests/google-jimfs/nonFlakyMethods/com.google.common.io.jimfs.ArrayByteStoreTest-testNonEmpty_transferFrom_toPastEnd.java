@Test public void testNonEmpty_transferFrom_toPastEnd() throws IOException {
  fillContent("222222");
  ByteBufferChannel channel=new ByteBufferChannel(buffer("111111"));
  assertEquals(6,store.transferFrom(channel,10,6));
  assertContentEquals("2222220000111111",store);
}
