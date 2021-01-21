@Test(expected=IOException.class) public void shouldNotInvokeDispatcherWhenServletContextOnlyStrategyIsUsed() throws Exception {
  final AtomicBoolean dispatcherInvokedFlag=new AtomicBoolean();
  victim=new ServletContextUriLocator(){
    @Override InputStream locateWithDispatcher(    final String uri) throws IOException {
      dispatcherInvokedFlag.set(true);
      throw new IOException("No resource exist");
    }
  }
;
  initLocator(victim);
  victim.setLocatorStrategy(LocatorStrategy.SERVLET_CONTEXT_ONLY);
  try {
    victim.locate("/test.css");
  }
  finally {
    assertFalse(dispatcherInvokedFlag.get());
  }
}
