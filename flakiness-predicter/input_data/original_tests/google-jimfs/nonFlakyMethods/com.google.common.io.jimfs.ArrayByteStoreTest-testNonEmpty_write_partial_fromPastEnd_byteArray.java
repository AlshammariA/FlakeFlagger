@Test public void testNonEmpty_write_partial_fromPastEnd_byteArray(){
  fillContent("222222");
  assertEquals(3,store.write(8,bytes("111")));
  assertContentEquals("22222200111",store);
  assertEquals(2,store.write(13,bytes("333333"),4,2));
  assertContentEquals("222222001110033",store);
}
