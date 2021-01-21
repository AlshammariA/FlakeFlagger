@Test public void testPaths_toAbsolutePath(){
  assertThat(path("/foo/bar").toAbsolutePath()).isAbsolute().and().hasRootComponent("/").and().hasNameComponents("foo","bar").and().is(path("/foo/bar"));
  assertThat(path("foo/bar").toAbsolutePath()).isAbsolute().and().hasRootComponent("/").and().hasNameComponents("work","foo","bar").and().is(path("/work/foo/bar"));
}
