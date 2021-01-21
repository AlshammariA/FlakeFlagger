@Test public void testMatching_starStar(){
  assertThat("**").matches("","a","abc","293874982374913794141","/foo/bar/baz","foo/bar.txt");
  assertThat("**foo").matches("foo","barfoo","/foo","/a/b/c/foo","c.foo","a/b/c.foo").doesNotMatch("foo.bar","/a/b/food");
  assertThat("/foo/**/bar.txt").matches("/foo/baz/bar.txt","/foo/bar/asdf/bar.txt").doesNotMatch("/foo/bar.txt","/foo/baz/bar");
  assertThat("**/*.java").matches("/Foo.java","foo/Bar.java","/.java","foo/.java");
}
