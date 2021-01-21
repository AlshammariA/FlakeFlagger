@Test public void testNonEmpty_write_overwrite_greaterLength(){
  fillContent("2222");
  assertEquals(8,store.write(0,buffer("12345678")));
  assertContentEquals("12345678",store);
}
