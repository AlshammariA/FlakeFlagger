@Test public void testEmpty_write_singleBuffer_atNonZeroPosition(){
  store.write(5,buffer("111"));
  assertContentEquals("00000111",store);
}
