@Test public void canLocateValidResource() throws Exception {
  when(mockRequest.getRequestURL()).thenReturn(new StringBuffer(""));
  assertNotNull(victim.getInputStream(mockRequest,mockResponse,"http://www.google.com"));
}
