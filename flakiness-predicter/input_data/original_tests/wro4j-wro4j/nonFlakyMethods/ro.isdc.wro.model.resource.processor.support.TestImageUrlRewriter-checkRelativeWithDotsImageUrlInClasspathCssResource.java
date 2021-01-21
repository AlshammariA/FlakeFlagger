@Test public void checkRelativeWithDotsImageUrlInClasspathCssResource(){
  final String actual=victim.rewrite(ClasspathUriLocator.createUri(DEFAULT_CSS_URI),"../" + RELATIVE_IMAGE_URL);
  final String expected=DEFAULT_PREFIX + "classpath:/path/" + RELATIVE_IMAGE_URL;
  assertEquals(expected,actual);
}
