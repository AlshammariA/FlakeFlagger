@Test public void testNonEmpty_write_partial_fromPastEnd_multipleBuffers(){
  fillContent("222222");
  assertEquals(4,store.write(10,buffers("11","33")));
  assertContentEquals("22222200001133",store);
}
