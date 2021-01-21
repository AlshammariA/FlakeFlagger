@Test public void testNonEmpty_write_partial_fromEnd_multipleBuffers(){
  fillContent("222222");
  assertEquals(6,store.write(6,buffers("111","333")));
  assertContentEquals("222222111333",store);
}
