@Test public void testNonEmpty_read_all_byteArray_largerThanContent(){
  fillContent("222222");
  byte[] array=new byte[10];
  assertEquals(6,store.read(0,array));
  assertArrayEquals(bytes("2222220000"),array);
  array=new byte[10];
  assertEquals(6,store.read(0,array,2,6));
  assertArrayEquals(bytes("0022222200"),array);
}
