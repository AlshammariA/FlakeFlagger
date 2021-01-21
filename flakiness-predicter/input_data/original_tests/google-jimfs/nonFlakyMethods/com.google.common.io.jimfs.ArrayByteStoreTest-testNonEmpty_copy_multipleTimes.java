@Test public void testNonEmpty_copy_multipleTimes(){
  fillContent("123456");
  ByteStore copy=store.copy(new FileKey(1234,REGULAR_FILE)).copy(new FileKey(1235,REGULAR_FILE));
  assertContentEquals("123456",copy);
}
