@Test public void shouldNotBeIncludedRequestByDefault(){
  assertFalse(DispatcherStreamLocator.isIncludedRequest(mockRequest));
}
