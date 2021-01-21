@Test public void testPaths_normalize(){
  assertThat(path("foo/bar/..").normalize()).isRelative().and().hasNameComponents("foo");
  assertThat(path("foo/./bar/../baz/test/./../stuff").normalize()).isRelative().and().hasNameComponents("foo","baz","stuff");
  assertThat(path("../../foo/./bar").normalize()).isRelative().and().hasNameComponents("..","..","foo","bar");
  assertThat(path("foo/../../bar").normalize()).isRelative().and().hasNameComponents("..","bar");
  assertThat(path(".././..").normalize()).isRelative().and().hasNameComponents("..","..");
}
