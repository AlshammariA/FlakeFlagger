@Test public void testNonEmpty_read_singleByte(){
  fillContent("123456");
  assertEquals(1,store.read(0));
  assertEquals(2,store.read(1));
  assertEquals(6,store.read(5));
  assertEquals(-1,store.read(6));
  assertEquals(-1,store.read(100));
}
