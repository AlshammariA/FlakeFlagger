@Test public void computePathFromLocationWithContextRoot(){
  final String result=WroUtil.getPathInfoFromLocation(mockContextPathRequest("/a"),"/a/b/c/d");
  assertEquals("/b/c/d",result);
}
