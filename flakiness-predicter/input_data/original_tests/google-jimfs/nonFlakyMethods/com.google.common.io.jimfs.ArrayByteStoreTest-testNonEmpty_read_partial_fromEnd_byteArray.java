@Test public void testNonEmpty_read_partial_fromEnd_byteArray(){
  fillContent("2222222222");
  byte[] array=new byte[3];
  assertEquals(2,store.read(8,array));
  assertArrayEquals(bytes("220"),array);
  array=new byte[10];
  assertEquals(2,store.read(8,array,1,3));
  assertArrayEquals(bytes("0220000000"),array);
}
