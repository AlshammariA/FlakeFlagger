@Test(expected=MalformedURLException.class) public void testExplicitClasspathUrlEmptyPath() throws Exception {
  LocationUtil.urlForResource(LocationUtil.CLASSPATH_SCHEME);
}
