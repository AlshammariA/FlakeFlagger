@Test public void testEmpty_write_singleByte_atStart(){
  store.write(0,(byte)1);
  assertContentEquals("1",store);
}
