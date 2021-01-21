@Test public void shouldNotApplyPatternsWhenIncludeMatches() throws Exception {
  checkThatInclusionNotMatches("/a/path/to.js","/**/*.less");
  checkThatInclusionNotMatches("/b/path/to.css","/a/*/to.*");
  checkThatInclusionNotMatches("/a/path/inner/bo.css","/a/**/to.*");
  checkThatInclusionNotMatches("/a/b/c/aame.css","/a/**/n?me.css");
  checkThatInclusionNotMatches("/a/b/c/name.less","/a/**/n?me.js","/a/**/n?me.c?s");
}
