@Test(expected=IllegalArgumentException.class) public void cannotComputeEmptyLocation(){
  WroUtil.getPathInfoFromLocation(mockContextPathRequest(null),"");
}
