@Test public void testNonEmpty_truncate_partial(){
  fillContent("12345678");
  store.truncate(5);
  assertContentEquals("12345",store);
}
