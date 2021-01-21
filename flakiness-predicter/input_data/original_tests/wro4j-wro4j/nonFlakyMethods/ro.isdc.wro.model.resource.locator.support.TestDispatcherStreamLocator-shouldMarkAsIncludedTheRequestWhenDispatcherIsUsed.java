@Test public void shouldMarkAsIncludedTheRequestWhenDispatcherIsUsed() throws Exception {
  shouldReturnsResourceIncludedByDispatcher();
  verify(mockRequest).setAttribute(DispatcherStreamLocator.ATTRIBUTE_INCLUDED_BY_DISPATCHER,Boolean.TRUE);
}
