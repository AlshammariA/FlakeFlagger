@Test public void computePathFromNestedLocation(){
  final String result=WroUtil.getPathInfoFromLocation(mockContextPathRequest(null),"/a/b/c/d");
  assertEquals("/b/c/d",result);
}
