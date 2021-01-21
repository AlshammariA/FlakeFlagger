@Test public void testEmpty_truncate_toZero(){
  store.truncate(0);
  assertContentEquals("",store);
}
