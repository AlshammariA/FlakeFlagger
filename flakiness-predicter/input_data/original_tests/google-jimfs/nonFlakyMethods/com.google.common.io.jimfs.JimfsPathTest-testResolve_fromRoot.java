@Test public void testResolve_fromRoot(){
  Path root=Iterables.getOnlyElement(fs.getRootDirectories());
  assertResolvedPathEquals("/foo",root,"foo");
  assertResolvedPathEquals("/foo/bar",root,"foo/bar");
  assertResolvedPathEquals("/foo/bar",root,"foo","bar");
  assertResolvedPathEquals("/foo/bar/baz/test",root,"foo/bar/baz/test");
  assertResolvedPathEquals("/foo/bar/baz/test",root,"foo","bar/baz","test");
}
