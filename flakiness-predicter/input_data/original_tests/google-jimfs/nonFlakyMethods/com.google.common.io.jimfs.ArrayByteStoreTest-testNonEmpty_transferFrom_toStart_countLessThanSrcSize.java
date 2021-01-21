@Test public void testNonEmpty_transferFrom_toStart_countLessThanSrcSize() throws IOException {
  fillContent("22222222");
  ByteBufferChannel channel=new ByteBufferChannel(buffer("11111"));
  assertEquals(3,store.transferFrom(channel,0,3));
  assertContentEquals("11122222",store);
}
