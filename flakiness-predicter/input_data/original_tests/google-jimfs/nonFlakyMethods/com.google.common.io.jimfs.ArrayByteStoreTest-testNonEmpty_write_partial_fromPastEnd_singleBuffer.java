@Test public void testNonEmpty_write_partial_fromPastEnd_singleBuffer(){
  fillContent("222222");
  assertEquals(3,store.write(8,buffer("111")));
  assertContentEquals("22222200111",store);
}
