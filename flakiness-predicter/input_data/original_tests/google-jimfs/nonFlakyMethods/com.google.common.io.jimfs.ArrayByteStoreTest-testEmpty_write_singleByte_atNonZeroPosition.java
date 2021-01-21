@Test public void testEmpty_write_singleByte_atNonZeroPosition(){
  store.write(5,(byte)1);
  assertContentEquals("000001",store);
}
