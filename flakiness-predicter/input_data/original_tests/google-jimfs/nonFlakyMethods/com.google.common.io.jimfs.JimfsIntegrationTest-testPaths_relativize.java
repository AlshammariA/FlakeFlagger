@Test public void testPaths_relativize(){
  assertThat(path("/foo/bar").relativize(path("/foo/bar/baz"))).isRelative().and().hasNameComponents("baz");
  assertThat(path("/foo/bar/baz").relativize(path("/foo/bar"))).isRelative().and().hasNameComponents("..");
  assertThat(path("/foo/bar/baz").relativize(path("/foo/baz/bar"))).isRelative().and().hasNameComponents("..","..","baz","bar");
  assertThat(path("foo/bar").relativize(path("foo"))).isRelative().and().hasNameComponents("..");
  assertThat(path("foo").relativize(path("foo/bar"))).isRelative().and().hasNameComponents("bar");
  try {
    path("/foo/bar").relativize(path("bar"));
    fail();
  }
 catch (  IllegalArgumentException expected) {
  }
  try {
    path("bar").relativize(path("/foo/bar"));
    fail();
  }
 catch (  IllegalArgumentException expected) {
  }
}
