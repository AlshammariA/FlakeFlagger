@Test public void testAbsolutePath_twoNames(){
  PathTester tester=new PathTester(fs,"/foo/bar").root("/").names("foo","bar");
  tester.test("/foo/bar");
}
