@Test public void checkRelativeImageUrlInContextRelativeCssResource(){
  final String actual=victim.rewrite(DEFAULT_CSS_URI,RELATIVE_IMAGE_URL);
  final String expected="/path/to/" + RELATIVE_IMAGE_URL;
  assertEquals(expected,actual);
}
