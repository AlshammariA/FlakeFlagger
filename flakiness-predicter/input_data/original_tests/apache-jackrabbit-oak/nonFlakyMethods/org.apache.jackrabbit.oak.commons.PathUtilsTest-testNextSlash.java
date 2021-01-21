public void testNextSlash(){
  String path="/test/a";
  int n=PathUtils.getNextSlash(path,0);
  assertEquals(0,n);
  n=PathUtils.getNextSlash(path,n + 1);
  assertEquals(5,n);
  n=PathUtils.getNextSlash(path,n + 1);
  assertEquals(-1,n);
}
