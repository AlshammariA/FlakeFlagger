@Test public void testEmpty_write_partialByteArray_atStart(){
  byte[] bytes=bytes("2211111122");
  store.write(0,bytes,2,6);
  assertContentEquals("111111",store);
}
