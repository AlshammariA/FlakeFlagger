@Test public void checkContextRelativeUrlInClasspathCssResource(){
  final String actual=victim.rewrite(ClasspathUriLocator.createUri(DEFAULT_CSS_URI),DEFAULT_IMAGE_URL);
  assertEquals(DEFAULT_IMAGE_URL,actual);
}
