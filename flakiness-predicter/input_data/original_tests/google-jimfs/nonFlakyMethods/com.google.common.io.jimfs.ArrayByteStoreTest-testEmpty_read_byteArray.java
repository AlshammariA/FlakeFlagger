@Test public void testEmpty_read_byteArray(){
  byte[] array=new byte[10];
  assertEquals(-1,store.read(0,array));
  assertEquals(-1,store.read(0,array,0,array.length));
  assertArrayEquals(bytes("0000000000"),array);
}
