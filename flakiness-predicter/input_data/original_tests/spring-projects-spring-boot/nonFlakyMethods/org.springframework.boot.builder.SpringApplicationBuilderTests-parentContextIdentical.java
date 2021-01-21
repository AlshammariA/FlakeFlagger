@Test public void parentContextIdentical() throws Exception {
  SpringApplicationBuilder application=new SpringApplicationBuilder(ExampleConfig.class);
  application.parent(ExampleConfig.class);
  application.contextClass(SpyApplicationContext.class);
  this.context=application.run();
  verify(((SpyApplicationContext)this.context).getApplicationContext()).setParent(any(ApplicationContext.class));
}
