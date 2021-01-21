@Test public void shouldNotFailWhenEachHandlerIsInvoked(){
  final Map<String,RequestHandler> map=victim.provideRequestHandlers();
  for (  final RequestHandler handler : map.values()) {
    injector.inject(handler);
    handler.accept(mockRequest);
    handler.isEnabled();
  }
}
