@Test public void testAbsolutePath_singleName(){
  PathTester tester=new PathTester(fs,"/foo").root("/").names("foo");
  tester.test("/foo");
}
