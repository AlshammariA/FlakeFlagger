@Test public void testNullEntityToString() throws Exception {
  try {
    EntityUtils.toString(null);
    Assert.fail("IllegalArgumentException should have been thrown");
  }
 catch (  IllegalArgumentException ex) {
  }
}
