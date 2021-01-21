@Test public void testNonEmpty_transferFrom_toStart_countGreaterThanSrcSize() throws IOException {
  fillContent("22222222");
  ByteBufferChannel channel=new ByteBufferChannel(buffer("11111"));
  assertEquals(5,store.transferFrom(channel,0,10));
  assertContentEquals("11111222",store);
}
