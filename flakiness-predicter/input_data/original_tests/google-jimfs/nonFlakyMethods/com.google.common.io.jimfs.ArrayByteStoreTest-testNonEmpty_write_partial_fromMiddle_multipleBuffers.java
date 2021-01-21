@Test public void testNonEmpty_write_partial_fromMiddle_multipleBuffers(){
  fillContent("22222222");
  assertEquals(4,store.write(2,buffers("11","33")));
  assertContentEquals("22113322",store);
}
