@Test public void testAbsoluteMultiNamePath_fourNames(){
  PathTester tester=new PathTester(fs,"/foo/bar/baz/test").root("/").names("foo","bar","baz","test");
  tester.test("/foo/bar/baz/test");
}
