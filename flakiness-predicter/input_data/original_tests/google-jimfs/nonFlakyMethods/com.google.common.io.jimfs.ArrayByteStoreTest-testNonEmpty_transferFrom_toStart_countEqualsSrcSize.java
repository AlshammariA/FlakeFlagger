@Test public void testNonEmpty_transferFrom_toStart_countEqualsSrcSize() throws IOException {
  fillContent("22222222");
  ByteBufferChannel channel=new ByteBufferChannel(buffer("11111"));
  assertEquals(5,store.transferFrom(channel,0,5));
  assertContentEquals("11111222",store);
}
