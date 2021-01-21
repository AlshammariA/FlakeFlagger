@Test public void testNonEmpty_read_partial_fromStart_byteArray(){
  fillContent("222222");
  byte[] array=new byte[3];
  assertEquals(3,store.read(0,array));
  assertArrayEquals(bytes("222"),array);
  array=new byte[10];
  assertEquals(3,store.read(0,array,1,3));
  assertArrayEquals(bytes("0222000000"),array);
}
