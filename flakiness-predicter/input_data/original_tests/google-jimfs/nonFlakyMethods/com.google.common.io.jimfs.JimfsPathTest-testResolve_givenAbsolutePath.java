@Test public void testResolve_givenAbsolutePath(){
  assertResolvedPathEquals("/test",fs.getPath("/foo"),"/test");
  assertResolvedPathEquals("/test",fs.getPath("foo"),"/test");
}
