@Test public void testNonEmpty_write_partial_fromBeforeEnd_singleBuffer(){
  fillContent("22222222");
  assertEquals(3,store.write(6,buffer("111")));
  assertContentEquals("222222111",store);
}
