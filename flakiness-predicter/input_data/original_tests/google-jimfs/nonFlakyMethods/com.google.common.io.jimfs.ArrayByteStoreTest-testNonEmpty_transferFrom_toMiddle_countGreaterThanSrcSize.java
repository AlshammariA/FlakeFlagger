@Test public void testNonEmpty_transferFrom_toMiddle_countGreaterThanSrcSize() throws IOException {
  fillContent("22222222");
  ByteBufferChannel channel=new ByteBufferChannel(buffer("1111"));
  assertEquals(4,store.transferFrom(channel,2,100));
  assertContentEquals("22111122",store);
}
