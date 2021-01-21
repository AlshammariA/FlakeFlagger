@Test public void testEmpty_write_multipleBuffers_atStart(){
  store.write(0,buffers("111","111"));
  assertContentEquals("111111",store);
}
