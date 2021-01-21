@Test public void testPaths(){
  assertThat("/").isAbsolute().and().hasRootComponent("/").and().hasNoNameComponents();
  assertThat("foo").isRelative().and().hasNameComponents("foo");
  assertThat("foo/bar").isRelative().and().hasNameComponents("foo","bar");
  assertThat("/foo/bar/baz").isAbsolute().and().hasRootComponent("/").and().hasNameComponents("foo","bar","baz");
}
