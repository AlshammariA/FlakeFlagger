@Test public void customResourceLoaderFromConstructor() throws Exception {
  ResourceLoader resourceLoader=new DefaultResourceLoader();
  TestSpringApplication application=new TestSpringApplication(resourceLoader,ExampleWebConfig.class);
  this.context=application.run();
  verify(application.getLoader()).setResourceLoader(resourceLoader);
}
