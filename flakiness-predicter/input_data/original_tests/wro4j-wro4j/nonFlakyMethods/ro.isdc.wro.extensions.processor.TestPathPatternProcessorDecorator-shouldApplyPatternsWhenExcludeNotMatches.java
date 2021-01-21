@Test public void shouldApplyPatternsWhenExcludeNotMatches() throws Exception {
  checkThatExclusionNotMatches("/a/path/to.js","/**/*.less");
  checkThatExclusionNotMatches("/b/path/to.css","/a/*/to.*");
  checkThatExclusionNotMatches("/a/path/inner/bo.css","/a/**/to.*");
  checkThatExclusionNotMatches("/a/b/c/aame.css","/a/**/n?me.css");
  checkThatExclusionNotMatches("/a/b/c/name.less","/a/**/n?me.js","/a/**/n?me.c?s");
}
