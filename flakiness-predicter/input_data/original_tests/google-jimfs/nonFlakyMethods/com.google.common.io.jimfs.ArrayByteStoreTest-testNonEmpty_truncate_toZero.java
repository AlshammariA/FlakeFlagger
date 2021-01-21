@Test public void testNonEmpty_truncate_toZero(){
  fillContent("123456");
  store.truncate(0);
  assertContentEquals("",store);
}
