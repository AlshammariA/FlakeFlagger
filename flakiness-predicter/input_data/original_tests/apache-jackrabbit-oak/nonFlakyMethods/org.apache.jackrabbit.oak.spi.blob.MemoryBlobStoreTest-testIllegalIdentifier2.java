@Test public void testIllegalIdentifier2() throws Exception {
  try {
    store.getBlobLength("ff");
    fail();
  }
 catch (  Exception e) {
  }
}
