@Test public void computePathFromSomeLocation(){
  final String result=WroUtil.getPathInfoFromLocation(mockContextPathRequest(null),"location");
  assertEquals("",result);
}
