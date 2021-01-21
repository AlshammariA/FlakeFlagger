@Test public void parentContextCreationWithChildShutdown() throws Exception {
  SpringApplicationBuilder application=new SpringApplicationBuilder(ChildConfig.class).contextClass(SpyApplicationContext.class).registerShutdownHook(true);
  application.parent(ExampleConfig.class);
  this.context=application.run();
  verify(((SpyApplicationContext)this.context).getApplicationContext()).setParent(any(ApplicationContext.class));
  assertThat(((SpyApplicationContext)this.context).getRegisteredShutdownHook(),equalTo(true));
}
