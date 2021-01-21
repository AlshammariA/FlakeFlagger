@Test public void testMatching_literal(){
  assertThat("foo").matches("foo");
  assertThat("/foo").matches("/foo");
  assertThat("/foo/bar/baz").matches("/foo/bar/baz");
}
