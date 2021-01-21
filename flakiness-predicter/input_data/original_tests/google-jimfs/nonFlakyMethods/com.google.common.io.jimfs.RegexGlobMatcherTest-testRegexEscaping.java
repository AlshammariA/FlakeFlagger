@Test public void testRegexEscaping(){
  assertGlobRegexIs("(","\\(");
  assertGlobRegexIs(".","\\.");
  assertGlobRegexIs("^","\\^");
  assertGlobRegexIs("$","\\$");
  assertGlobRegexIs("+","\\+");
  assertGlobRegexIs("\\\\","\\\\");
  assertGlobRegexIs("]","\\]");
  assertGlobRegexIs(")","\\)");
  assertGlobRegexIs("}","\\}");
}
