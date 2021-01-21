@Test public void testEmpty_write_singleBuffer_atStart(){
  store.write(0,buffer("111111"));
  assertContentEquals("111111",store);
}
