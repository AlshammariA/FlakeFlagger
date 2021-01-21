@Test public void testIllegalIdentifier() throws Exception {
  byte[] data=new byte[1];
  try {
    store.readBlob("ff",0,data,0,1);
    fail();
  }
 catch (  Exception e) {
  }
}
