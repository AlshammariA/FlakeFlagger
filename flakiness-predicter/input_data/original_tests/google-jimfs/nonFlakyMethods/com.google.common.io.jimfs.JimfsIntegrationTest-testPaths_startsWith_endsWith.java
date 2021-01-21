@Test public void testPaths_startsWith_endsWith(){
  ASSERT.that(path("/foo/bar").startsWith("/")).isTrue();
  ASSERT.that(path("/foo/bar").startsWith("/foo")).isTrue();
  ASSERT.that(path("/foo/bar").startsWith("/foo/bar")).isTrue();
  ASSERT.that(path("/foo/bar").endsWith("bar")).isTrue();
  ASSERT.that(path("/foo/bar").endsWith("foo/bar")).isTrue();
  ASSERT.that(path("/foo/bar").endsWith("/foo/bar")).isTrue();
  ASSERT.that(path("/foo/bar").endsWith("/foo")).isFalse();
  ASSERT.that(path("/foo/bar").startsWith("foo/bar")).isFalse();
}
