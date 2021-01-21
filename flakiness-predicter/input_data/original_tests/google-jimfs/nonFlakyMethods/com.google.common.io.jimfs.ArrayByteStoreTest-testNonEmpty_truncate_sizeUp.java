@Test public void testNonEmpty_truncate_sizeUp(){
  fillContent("123456");
  store.truncate(12);
  assertContentEquals("123456",store);
}
