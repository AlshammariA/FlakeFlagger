@Test public void testNonEmpty_read_partial_fromMiddle_byteArray(){
  fillContent("22223333");
  byte[] array=new byte[3];
  assertEquals(3,store.read(3,array));
  assertArrayEquals(bytes("233"),array);
  array=new byte[10];
  assertEquals(3,store.read(3,array,1,3));
  assertArrayEquals(bytes("0233000000"),array);
}
