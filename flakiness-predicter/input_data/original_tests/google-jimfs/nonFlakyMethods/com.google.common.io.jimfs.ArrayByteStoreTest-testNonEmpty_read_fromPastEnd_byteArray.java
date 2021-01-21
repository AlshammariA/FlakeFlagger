@Test public void testNonEmpty_read_fromPastEnd_byteArray(){
  fillContent("123");
  byte[] array=new byte[3];
  assertEquals(-1,store.read(3,array));
  assertArrayEquals(bytes("000"),array);
  assertEquals(-1,store.read(3,array,0,2));
  assertArrayEquals(bytes("000"),array);
}
