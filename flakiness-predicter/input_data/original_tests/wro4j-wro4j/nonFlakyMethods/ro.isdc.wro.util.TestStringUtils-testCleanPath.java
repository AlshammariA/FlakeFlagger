@Test public void testCleanPath(){
  final String result=StringUtils.cleanPath("/a/b/../d.txt");
  assertEquals("/a/d.txt",result);
}
