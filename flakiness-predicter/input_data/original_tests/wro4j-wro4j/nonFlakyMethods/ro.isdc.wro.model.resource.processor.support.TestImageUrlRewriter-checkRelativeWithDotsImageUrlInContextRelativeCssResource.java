@Test public void checkRelativeWithDotsImageUrlInContextRelativeCssResource(){
  final String actual=victim.rewrite(DEFAULT_CSS_URI,"../" + RELATIVE_IMAGE_URL);
  final String expected="/path/" + RELATIVE_IMAGE_URL;
  assertEquals(expected,actual);
}
