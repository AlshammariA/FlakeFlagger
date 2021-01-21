@Test public void testResolve_givenEmptyPath(){
  assertResolvedPathEquals("/foo",fs.getPath("/foo"),"");
  assertResolvedPathEquals("foo",fs.getPath("foo"),"");
}
