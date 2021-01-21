@Test public void testEncode(){
  assertEquals("str:foo",TypeCodes.encode(PropertyType.STRING,"foo"));
  assertEquals(":blobId:",TypeCodes.encode(PropertyType.BINARY,""));
  assertEquals("und:foo",TypeCodes.encode(PropertyType.UNDEFINED,"foo"));
}
