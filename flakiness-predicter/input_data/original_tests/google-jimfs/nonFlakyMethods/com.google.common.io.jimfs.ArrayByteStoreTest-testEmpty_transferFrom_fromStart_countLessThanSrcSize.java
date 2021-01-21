@Test public void testEmpty_transferFrom_fromStart_countLessThanSrcSize() throws IOException {
  long transferred=store.transferFrom(new ByteBufferChannel(buffer("111111")),0,3);
  assertEquals(3,transferred);
  assertContentEquals("111",store);
}
