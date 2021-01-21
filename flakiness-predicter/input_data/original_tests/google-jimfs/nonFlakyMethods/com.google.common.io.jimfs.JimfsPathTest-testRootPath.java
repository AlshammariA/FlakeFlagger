@Test public void testRootPath(){
  new PathTester(fs,"/").root("/").test("/");
}
