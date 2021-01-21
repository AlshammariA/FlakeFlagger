public void testPartRegion() throws Exception {
  matcher.setRegex("test");
  matcher.start();
  assertTrue(matcher.matches("test"));
  assertTrue(matcher.matches("xxxxtest"));
  assertTrue(matcher.matches("testxxxx"));
  assertTrue(matcher.matches("xxxxtestxxxx"));
}
