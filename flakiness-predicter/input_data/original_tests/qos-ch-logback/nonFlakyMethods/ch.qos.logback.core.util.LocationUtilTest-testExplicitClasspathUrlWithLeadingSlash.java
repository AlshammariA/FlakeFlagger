@Test public void testExplicitClasspathUrlWithLeadingSlash() throws Exception {
  URL url=LocationUtil.urlForResource(LocationUtil.CLASSPATH_SCHEME + "/" + TEST_CLASSPATH_RESOURCE);
  validateResource(url);
}
