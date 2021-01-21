@Test public void testEmpty_transferFrom_fromStart_countGreaterThanSrcSize() throws IOException {
  long transferred=store.transferFrom(new ByteBufferChannel(buffer("111111")),0,12);
  assertEquals(6,transferred);
  assertContentEquals("111111",store);
}
