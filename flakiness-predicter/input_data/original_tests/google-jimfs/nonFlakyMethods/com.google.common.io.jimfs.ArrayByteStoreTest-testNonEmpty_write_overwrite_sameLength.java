@Test public void testNonEmpty_write_overwrite_sameLength(){
  fillContent("2222");
  assertEquals(4,store.write(0,buffer("1234")));
  assertContentEquals("1234",store);
}
