@Test public void testNonEmpty_write_partial_fromMiddle_singleByte(){
  fillContent("222222");
  assertEquals(1,store.write(3,(byte)1));
  assertContentEquals("222122",store);
}
