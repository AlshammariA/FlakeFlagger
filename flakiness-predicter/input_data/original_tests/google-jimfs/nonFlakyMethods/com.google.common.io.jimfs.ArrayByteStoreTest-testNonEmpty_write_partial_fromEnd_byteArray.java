@Test public void testNonEmpty_write_partial_fromEnd_byteArray(){
  fillContent("222222");
  assertEquals(3,store.write(6,bytes("111")));
  assertContentEquals("222222111",store);
  assertEquals(2,store.write(9,bytes("333333"),3,2));
  assertContentEquals("22222211133",store);
}
