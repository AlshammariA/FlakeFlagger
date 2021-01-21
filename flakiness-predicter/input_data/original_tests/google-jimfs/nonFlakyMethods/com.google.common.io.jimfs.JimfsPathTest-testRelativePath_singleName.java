@Test public void testRelativePath_singleName(){
  new PathTester(fs,"test").names("test").test("test");
  Path path=fs.getPath("test");
  assertEquals(path,path.getFileName());
}
