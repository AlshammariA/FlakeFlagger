@Test public void testNonEmpty_copy(){
  fillContent("123456");
  ByteStore copy=store.copy(new FileKey(1234,REGULAR_FILE));
  assertContentEquals("123456",copy);
}
