@Test public void test(){
  victim=new LazyRequestHandlerDecorator(new LazyInitializer<RequestHandler>(){
    @Override protected RequestHandler initialize(){
      return new CustomRequestHandler();
    }
  }
);
  WroTestUtils.createInjector().inject(victim);
  assertTrue(victim.isEnabled());
}
