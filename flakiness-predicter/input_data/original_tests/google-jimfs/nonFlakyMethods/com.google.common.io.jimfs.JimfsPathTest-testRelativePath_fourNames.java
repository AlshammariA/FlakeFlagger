@Test public void testRelativePath_fourNames(){
  PathTester tester=new PathTester(fs,"foo/bar/baz/test").names("foo","bar","baz","test");
  tester.test("foo/bar/baz/test");
}
