@Test public void testNonEmpty_transferFrom_toMiddle_countLessThanSrcSize() throws IOException {
  fillContent("22222222");
  ByteBufferChannel channel=new ByteBufferChannel(buffer("11111"));
  assertEquals(3,store.transferFrom(channel,2,3));
  assertContentEquals("22111222",store);
}
