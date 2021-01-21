@Test public void testNonEmpty_write_partial_fromStart_multipleBuffers(){
  fillContent("222222");
  assertEquals(4,store.write(0,buffers("11","33")));
  assertContentEquals("113322",store);
}
