@Test public void testNonEmpty_write_partial_fromEnd_singleByte(){
  fillContent("222222");
  assertEquals(1,store.write(6,(byte)1));
  assertContentEquals("2222221",store);
}
