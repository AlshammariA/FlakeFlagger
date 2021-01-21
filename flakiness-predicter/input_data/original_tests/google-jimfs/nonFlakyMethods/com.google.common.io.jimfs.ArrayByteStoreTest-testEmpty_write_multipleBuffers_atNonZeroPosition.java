@Test public void testEmpty_write_multipleBuffers_atNonZeroPosition(){
  store.write(5,buffers("111","222"));
  assertContentEquals("00000111222",store);
}
