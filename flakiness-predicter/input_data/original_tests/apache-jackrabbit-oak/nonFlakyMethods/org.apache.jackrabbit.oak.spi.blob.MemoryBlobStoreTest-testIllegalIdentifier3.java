@Test public void testIllegalIdentifier3() throws Exception {
  if (store instanceof AbstractBlobStore) {
    try {
      ((AbstractBlobStore)store).mark("ff");
      fail();
    }
 catch (    Exception e) {
    }
  }
}
