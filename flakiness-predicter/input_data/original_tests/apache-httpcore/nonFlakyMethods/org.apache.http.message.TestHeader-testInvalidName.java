@Test public void testInvalidName(){
  try {
    new BasicHeader(null,null);
    Assert.fail("IllegalArgumentException should have been thrown");
  }
 catch (  IllegalArgumentException ex) {
  }
}
