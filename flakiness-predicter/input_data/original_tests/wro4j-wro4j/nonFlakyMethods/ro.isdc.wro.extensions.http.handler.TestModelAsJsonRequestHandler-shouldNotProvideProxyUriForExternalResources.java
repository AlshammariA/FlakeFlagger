@Test public void shouldNotProvideProxyUriForExternalResources() throws IOException {
  when(mockModelFactory.create()).thenReturn(createWroModelExternalModelStub());
  final WroManagerFactory managerFactory=new BaseWroManagerFactory().setModelFactory(mockModelFactory);
  victim=new ModelAsJsonRequestHandler();
  final Injector injector=InjectorBuilder.create(managerFactory).build();
  injector.inject(victim);
  victim.handle(mockRequest,mockResponse);
  assertEquals(readJsonFile("wroModel_external.json"),outputStream.toString());
}
