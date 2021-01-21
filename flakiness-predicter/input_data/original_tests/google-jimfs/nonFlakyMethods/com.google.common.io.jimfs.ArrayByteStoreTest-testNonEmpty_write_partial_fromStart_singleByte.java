@Test public void testNonEmpty_write_partial_fromStart_singleByte(){
  fillContent("222222");
  assertEquals(1,store.write(0,(byte)1));
  assertContentEquals("122222",store);
}
