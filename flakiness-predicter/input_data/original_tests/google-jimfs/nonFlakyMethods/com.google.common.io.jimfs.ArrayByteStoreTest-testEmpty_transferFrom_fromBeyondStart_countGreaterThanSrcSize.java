@Test public void testEmpty_transferFrom_fromBeyondStart_countGreaterThanSrcSize() throws IOException {
  long transferred=store.transferFrom(new ByteBufferChannel(buffer("111111")),4,12);
  assertEquals(6,transferred);
  assertContentEquals("0000111111",store);
}
