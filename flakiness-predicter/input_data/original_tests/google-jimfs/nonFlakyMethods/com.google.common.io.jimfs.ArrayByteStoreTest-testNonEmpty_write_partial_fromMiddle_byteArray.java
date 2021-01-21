@Test public void testNonEmpty_write_partial_fromMiddle_byteArray(){
  fillContent("22222222");
  assertEquals(3,store.write(3,buffer("111")));
  assertContentEquals("22211122",store);
  assertEquals(2,store.write(5,bytes("333333"),1,2));
  assertContentEquals("22211332",store);
}
