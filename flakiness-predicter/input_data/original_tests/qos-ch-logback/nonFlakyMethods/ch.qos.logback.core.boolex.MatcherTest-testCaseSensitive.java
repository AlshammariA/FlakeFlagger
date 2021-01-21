public void testCaseSensitive() throws Exception {
  matcher.setRegex("test");
  matcher.setCaseSensitive(true);
  matcher.start();
  assertFalse(matcher.matches("TEST"));
  assertFalse(matcher.matches("tEst"));
  assertFalse(matcher.matches("tESt"));
  assertFalse(matcher.matches("TesT"));
}
