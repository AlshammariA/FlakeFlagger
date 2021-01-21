@Test public void parentContextWithClassLoader() throws Exception {
  SpringApplicationBuilder application=new SpringApplicationBuilder(ChildConfig.class).contextClass(SpyApplicationContext.class);
  ClassLoader classLoader=new URLClassLoader(new URL[0],getClass().getClassLoader());
  application.resourceLoader(new DefaultResourceLoader(classLoader));
  application.parent(ExampleConfig.class);
  this.context=application.run();
  assertThat(((SpyApplicationContext)this.context).getResourceLoader().getClassLoader(),is(equalTo(classLoader)));
}
