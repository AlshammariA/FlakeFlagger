@Test public void testGetTokenInfoBeforeAuthenticate(){
  try {
    authentication.getTokenInfo();
    fail("IllegalStateException expected");
  }
 catch (  IllegalStateException e) {
  }
}
