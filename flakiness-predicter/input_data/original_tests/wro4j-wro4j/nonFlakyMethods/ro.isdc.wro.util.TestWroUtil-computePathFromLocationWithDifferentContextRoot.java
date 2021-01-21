@Test public void computePathFromLocationWithDifferentContextRoot(){
  final String result=WroUtil.getPathInfoFromLocation(mockContextPathRequest("/z"),"/a/b/c/d");
  assertEquals("/a/b/c/d",result);
}
