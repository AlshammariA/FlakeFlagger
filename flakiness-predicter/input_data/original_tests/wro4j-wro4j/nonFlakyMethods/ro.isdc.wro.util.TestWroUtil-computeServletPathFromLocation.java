@Test public void computeServletPathFromLocation(){
  final String result=WroUtil.getServletPathFromLocation(mockContextPathRequest(null),"/a/b/c/d");
  assertEquals("/a",result);
}
