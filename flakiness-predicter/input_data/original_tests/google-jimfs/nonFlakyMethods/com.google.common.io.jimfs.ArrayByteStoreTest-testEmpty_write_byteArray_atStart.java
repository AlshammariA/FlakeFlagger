@Test public void testEmpty_write_byteArray_atStart(){
  byte[] bytes=bytes("111111");
  store.write(0,bytes);
  assertContentEquals(bytes,store);
}
