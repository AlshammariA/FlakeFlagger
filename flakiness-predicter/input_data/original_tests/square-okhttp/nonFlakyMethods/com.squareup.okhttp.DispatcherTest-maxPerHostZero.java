@Test public void maxPerHostZero() throws Exception {
  try {
    dispatcher.setMaxRequestsPerHost(0);
    fail();
  }
 catch (  IllegalArgumentException expected) {
  }
}
