@Test public void testIllegalConstructor() throws Exception {
  try {
    new BufferedHttpEntity(null);
    Assert.fail("IllegalArgumentException should have been thrown");
  }
 catch (  IllegalArgumentException ex) {
  }
}
