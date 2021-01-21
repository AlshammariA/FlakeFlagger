@Test public void testRegexTranslationWithMultipleSeparators(){
  assertGlobRegexIs("?","[^\\/]","\\/");
  assertGlobRegexIs("*","[^\\/]*","\\/");
  assertGlobRegexIs("/","[\\/]","\\/");
  assertGlobRegexIs("\\\\","[\\/]","\\/");
}
