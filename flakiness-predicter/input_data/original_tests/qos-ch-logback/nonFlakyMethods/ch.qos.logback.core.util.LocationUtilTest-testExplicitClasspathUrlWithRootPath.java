@Test(expected=MalformedURLException.class) public void testExplicitClasspathUrlWithRootPath() throws Exception {
  LocationUtil.urlForResource(LocationUtil.CLASSPATH_SCHEME + "/");
}
