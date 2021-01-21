@Test public void testEmpty_copy(){
  ByteStore copy=store.copy(new FileKey(1234,REGULAR_FILE));
  assertContentEquals("",copy);
}
