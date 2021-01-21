@Test public void testEmptyIdentifier() throws Exception {
  byte[] data=new byte[1];
  assertEquals(-1,store.readBlob("",0,data,0,1));
  assertEquals(0,store.getBlobLength(""));
}
