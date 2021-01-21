@Test public void testNonEmpty_write_partial_fromStart_byteArray(){
  fillContent("222222");
  assertEquals(3,store.write(0,bytes("111")));
  assertContentEquals("111222",store);
  assertEquals(2,store.write(0,bytes("333333"),0,2));
  assertContentEquals("331222",store);
}
