@Test(expected=IOException.class) public void cannotLocateInvalidLocation() throws Exception {
  victim.getInputStream(mockRequest,mockResponse,"/INVALID");
}
