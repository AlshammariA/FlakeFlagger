@Test(expected=IOException.class) public void cannotLocateNullLocation() throws Exception {
  victim.getInputStream(mockRequest,mockResponse,null);
}
