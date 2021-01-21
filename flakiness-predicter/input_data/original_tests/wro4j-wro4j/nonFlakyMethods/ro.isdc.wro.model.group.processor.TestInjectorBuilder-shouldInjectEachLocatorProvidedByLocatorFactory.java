@Test(expected=IOException.class) public void shouldInjectEachLocatorProvidedByLocatorFactory() throws Exception {
  final UriLocatorFactory uriLocatorFactory=new DefaultUriLocatorFactory();
  final WroManagerFactory managerFactory=new BaseWroManagerFactory().setUriLocatorFactory(uriLocatorFactory);
  final Injector injector=InjectorBuilder.create(managerFactory).build();
  final Sample sample=new Sample();
  injector.inject(sample);
  sample.uriLocatorFactory.locate("/path/to/servletContext/resource.js");
}
