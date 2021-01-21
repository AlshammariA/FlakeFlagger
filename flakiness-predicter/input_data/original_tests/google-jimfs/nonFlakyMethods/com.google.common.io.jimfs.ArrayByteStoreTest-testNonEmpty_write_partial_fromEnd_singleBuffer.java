@Test public void testNonEmpty_write_partial_fromEnd_singleBuffer(){
  fillContent("222222");
  assertEquals(3,store.write(6,buffer("111")));
  assertContentEquals("222222111",store);
}
