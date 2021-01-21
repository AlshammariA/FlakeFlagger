@Test public void testNonEmpty_transferFrom_toEnd() throws IOException {
  fillContent("222222");
  ByteBufferChannel channel=new ByteBufferChannel(buffer("111111"));
  assertEquals(6,store.transferFrom(channel,6,6));
  assertContentEquals("222222111111",store);
}
