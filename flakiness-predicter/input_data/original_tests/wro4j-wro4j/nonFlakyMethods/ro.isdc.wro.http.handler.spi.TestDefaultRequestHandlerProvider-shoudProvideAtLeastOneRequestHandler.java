@Test public void shoudProvideAtLeastOneRequestHandler(){
  final Map<String,RequestHandler> map=victim.provideRequestHandlers();
  assertFalse(map.isEmpty());
}
