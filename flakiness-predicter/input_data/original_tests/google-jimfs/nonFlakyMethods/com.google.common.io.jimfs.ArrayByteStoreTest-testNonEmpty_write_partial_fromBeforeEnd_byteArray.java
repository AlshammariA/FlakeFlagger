@Test public void testNonEmpty_write_partial_fromBeforeEnd_byteArray(){
  fillContent("22222222");
  assertEquals(3,store.write(6,bytes("111")));
  assertContentEquals("222222111",store);
  assertEquals(2,store.write(8,bytes("333333"),2,2));
  assertContentEquals("2222221133",store);
}
