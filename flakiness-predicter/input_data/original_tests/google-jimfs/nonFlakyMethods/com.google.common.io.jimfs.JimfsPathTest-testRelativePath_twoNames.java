@Test public void testRelativePath_twoNames(){
  PathTester tester=new PathTester(fs,"foo/bar").names("foo","bar");
  tester.test("foo/bar");
}
