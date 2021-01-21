@Test public void testEmpty_transferFrom_fromBeyondStart_countLessThanSrcSize() throws IOException {
  long transferred=store.transferFrom(new ByteBufferChannel(buffer("111111")),4,3);
  assertEquals(3,transferred);
  assertContentEquals("0000111",store);
}
