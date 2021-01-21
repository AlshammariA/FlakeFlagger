@Test public void testEmpty_write_partialByteArray_atNonZeroPosition(){
  byte[] bytes=bytes("2211111122");
  store.write(5,bytes,2,6);
  assertContentEquals("00000111111",store);
}
