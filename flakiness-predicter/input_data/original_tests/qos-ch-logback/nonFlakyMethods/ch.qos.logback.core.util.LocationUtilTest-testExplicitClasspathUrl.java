@Test public void testExplicitClasspathUrl() throws Exception {
  URL url=LocationUtil.urlForResource(LocationUtil.CLASSPATH_SCHEME + TEST_CLASSPATH_RESOURCE);
  validateResource(url);
}
