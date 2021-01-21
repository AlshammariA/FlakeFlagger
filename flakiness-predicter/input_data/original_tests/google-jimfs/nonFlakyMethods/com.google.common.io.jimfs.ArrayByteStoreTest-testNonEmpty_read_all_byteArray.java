@Test public void testNonEmpty_read_all_byteArray(){
  fillContent("222222");
  byte[] array=new byte[6];
  assertEquals(6,store.read(0,array));
  assertArrayEquals(bytes("222222"),array);
}
