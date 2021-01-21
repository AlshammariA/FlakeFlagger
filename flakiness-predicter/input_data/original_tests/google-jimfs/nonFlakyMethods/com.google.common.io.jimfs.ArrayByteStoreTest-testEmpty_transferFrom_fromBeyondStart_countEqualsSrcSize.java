@Test public void testEmpty_transferFrom_fromBeyondStart_countEqualsSrcSize() throws IOException {
  long transferred=store.transferFrom(new ByteBufferChannel(buffer("111111")),4,6);
  assertEquals(6,transferred);
  assertContentEquals("0000111111",store);
}
