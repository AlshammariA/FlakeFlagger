@Test public void testEmpty_truncate_sizeUp(){
  store.truncate(10);
  assertContentEquals("",store);
}
