@Test public void shouldApplyPatternsWhenIncludeMatches() throws Exception {
  checkThatInclusionMatches("/a/path/to.less","/**/*.less");
  checkThatInclusionMatches("/a/path/to.css","/a/*/to.*");
  checkThatInclusionMatches("/a/path/inner/to.css","/a/**/to.*");
  checkThatInclusionMatches("/a/b/c/name.css","/a/**/n?me.css");
  checkThatInclusionMatches("/a/b/c/name.css","/a/**/n?me.js","/a/**/n?me.c?s");
}
