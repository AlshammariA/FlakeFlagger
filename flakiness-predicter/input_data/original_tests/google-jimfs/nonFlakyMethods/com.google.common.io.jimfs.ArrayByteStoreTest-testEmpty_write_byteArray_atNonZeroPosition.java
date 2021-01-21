@Test public void testEmpty_write_byteArray_atNonZeroPosition(){
  byte[] bytes=bytes("111111");
  store.write(5,bytes);
  assertContentEquals("00000111111",store);
}
