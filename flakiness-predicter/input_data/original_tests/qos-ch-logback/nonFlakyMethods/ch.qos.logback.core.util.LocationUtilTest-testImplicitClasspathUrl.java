@Test public void testImplicitClasspathUrl() throws Exception {
  URL url=LocationUtil.urlForResource(TEST_CLASSPATH_RESOURCE);
  validateResource(url);
}
