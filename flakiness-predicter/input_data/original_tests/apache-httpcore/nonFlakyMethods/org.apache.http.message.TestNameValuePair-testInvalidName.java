@Test public void testInvalidName(){
  try {
    new BasicNameValuePair(null,null);
    Assert.fail("IllegalArgumentException should have been thrown");
  }
 catch (  IllegalArgumentException ex) {
  }
}
