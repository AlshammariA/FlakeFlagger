@Test public void testRegexTranslation(){
  assertGlobRegexIs("foo","foo");
  assertGlobRegexIs("/","/");
  assertGlobRegexIs("?","[^/]");
  assertGlobRegexIs("*","[^/]*");
  assertGlobRegexIs("**",".*");
  assertGlobRegexIs("/foo","/foo");
  assertGlobRegexIs("?oo","[^/]oo");
  assertGlobRegexIs("*oo","[^/]*oo");
  assertGlobRegexIs("**/*.java",".*/[^/]*\\.java");
  assertGlobRegexIs("[a-z]","[[^/]&&[a-z]]");
  assertGlobRegexIs("[!a-z]","[[^/]&&[^a-z]]");
  assertGlobRegexIs("[-a-z]","[[^/]&&[-a-z]]");
  assertGlobRegexIs("[!-a-z]","[[^/]&&[^-a-z]]");
  assertGlobRegexIs("{a,b,c}","(a|b|c)");
  assertGlobRegexIs("{?oo,[A-Z]*,foo/**}","([^/]oo|[[^/]&&[A-Z]][^/]*|foo/.*)");
}
