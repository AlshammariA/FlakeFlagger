@Test public void maxRequestsZero() throws Exception {
  try {
    dispatcher.setMaxRequests(0);
    fail();
  }
 catch (  IllegalArgumentException expected) {
  }
}
