public void testCaseInsensitive() throws Exception {
  matcher.setRegex("test");
  matcher.setCaseSensitive(false);
  matcher.start();
  assertTrue(matcher.matches("TEST"));
  assertTrue(matcher.matches("tEst"));
  assertTrue(matcher.matches("tESt"));
  assertTrue(matcher.matches("TesT"));
}
