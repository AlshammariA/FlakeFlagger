@Test public void checkRelativeImageUrlInProtectedContextRelativeCssResource(){
  final String actual=victim.rewrite(PROTECTED_CSS_URI,RELATIVE_IMAGE_URL);
  final String expected=DEFAULT_PREFIX + "/WEB-INF/path/to/" + RELATIVE_IMAGE_URL;
  assertEquals(expected,actual);
}
