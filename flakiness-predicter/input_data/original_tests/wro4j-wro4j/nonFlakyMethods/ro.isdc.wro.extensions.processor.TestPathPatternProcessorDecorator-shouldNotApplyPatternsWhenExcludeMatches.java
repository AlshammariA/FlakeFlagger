@Test public void shouldNotApplyPatternsWhenExcludeMatches() throws Exception {
  checkThatExclusionMatches("/a/path/to.less","/**/*.less");
  checkThatExclusionMatches("/a/path/to.css","/a/*/to.*");
  checkThatExclusionMatches("/a/path/inner/to.css","/a/**/to.*");
  checkThatExclusionMatches("/a/b/c/name.css","/a/**/n?me.css");
  checkThatExclusionMatches("/a/b/c/name.css","/a/**/n?me.js","/a/**/n?me.c?s");
}
