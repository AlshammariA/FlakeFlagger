@Test public void shouldCleanPathContainingMultipleDoubleDots(){
  final String result=StringUtils.cleanPath("/a/b/../../d.txt");
  assertEquals("/d.txt",result);
}
