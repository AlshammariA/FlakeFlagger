@Test public void testGetProvisionalVersionForDimension() throws Exception {
  for (int i=1; i <= 40; i++) {
    assertEquals(i,Version.getProvisionalVersionForDimension(4 * i + 17).getVersionNumber());
  }
}
