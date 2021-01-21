@Test public void testNonEmpty_write_partial_fromMiddle_singleBuffer(){
  fillContent("22222222");
  assertEquals(3,store.write(3,buffer("111")));
  assertContentEquals("22211122",store);
}
