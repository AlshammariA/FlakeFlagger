@Test public void shouldCreateListOfDefaultRequestHandlers(){
  final Collection<RequestHandler> requestHandlers=victim.create();
  assertEquals(false,requestHandlers.isEmpty());
}
