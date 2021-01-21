@Test public void testPaths_resolve(){
  assertThat(path("/").resolve("foo/bar")).isAbsolute().and().hasRootComponent("/").and().hasNameComponents("foo","bar");
  assertThat(path("foo/bar").resolveSibling("baz")).isRelative().and().hasNameComponents("foo","baz");
  assertThat(path("foo/bar").resolve("/one/two")).isAbsolute().and().hasRootComponent("/").and().hasNameComponents("one","two");
}
