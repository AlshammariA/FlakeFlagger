@Test public void testEmpty_transferFrom_fromStart_countEqualsSrcSize() throws IOException {
  long transferred=store.transferFrom(new ByteBufferChannel(buffer("111111")),0,6);
  assertEquals(6,transferred);
  assertContentEquals("111111",store);
}
