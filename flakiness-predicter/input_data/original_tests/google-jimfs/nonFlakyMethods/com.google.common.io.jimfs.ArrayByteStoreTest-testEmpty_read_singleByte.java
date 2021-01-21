@Test public void testEmpty_read_singleByte(){
  assertEquals(-1,store.read(0));
  assertEquals(-1,store.read(1));
}
