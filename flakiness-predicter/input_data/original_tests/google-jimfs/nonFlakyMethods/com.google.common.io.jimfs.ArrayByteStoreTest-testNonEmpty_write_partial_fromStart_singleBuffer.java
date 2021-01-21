@Test public void testNonEmpty_write_partial_fromStart_singleBuffer(){
  fillContent("222222");
  assertEquals(3,store.write(0,buffer("111")));
  assertContentEquals("111222",store);
}
