@Test public void checkRelativeImageUrlInClasspathCssResourceWhenContextPathIsNotDefault(){
  context.setContextPath("/1/2/3");
  final String actual=victim.rewrite(ClasspathUriLocator.createUri(DEFAULT_CSS_URI),RELATIVE_IMAGE_URL);
  final String expected=DEFAULT_PREFIX + "classpath:/path/to/" + RELATIVE_IMAGE_URL;
  assertEquals(expected,actual);
}
