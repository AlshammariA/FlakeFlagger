@Test public void testNullPointerExceptions(){
  NullPointerTester tester=new NullPointerTester();
  tester.testAllPublicInstanceMethods(fs.getPath("/"));
  tester.testAllPublicInstanceMethods(fs.getPath(""));
  tester.testAllPublicInstanceMethods(fs.getPath("/foo"));
  tester.testAllPublicInstanceMethods(fs.getPath("/foo/bar/baz"));
  tester.testAllPublicInstanceMethods(fs.getPath("foo"));
  tester.testAllPublicInstanceMethods(fs.getPath("foo/bar"));
  tester.testAllPublicInstanceMethods(fs.getPath("foo/bar/baz"));
  tester.testAllPublicInstanceMethods(fs.getPath("."));
  tester.testAllPublicInstanceMethods(fs.getPath(".."));
}
