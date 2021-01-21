@Test public void testNonEmpty_transferFrom_hugeOverestimateCount() throws IOException {
  fillContent("222222");
  ByteBufferChannel channel=new ByteBufferChannel(buffer("111111"));
  assertEquals(6,store.transferFrom(channel,6,1024 * 1024 * 10));
  assertContentEquals("222222111111",store);
}
