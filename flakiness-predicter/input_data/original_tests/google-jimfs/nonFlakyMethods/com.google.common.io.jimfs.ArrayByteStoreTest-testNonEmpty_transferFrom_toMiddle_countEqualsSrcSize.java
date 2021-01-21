@Test public void testNonEmpty_transferFrom_toMiddle_countEqualsSrcSize() throws IOException {
  fillContent("22222222");
  ByteBufferChannel channel=new ByteBufferChannel(buffer("1111"));
  assertEquals(4,store.transferFrom(channel,2,4));
  assertContentEquals("22111122",store);
}
