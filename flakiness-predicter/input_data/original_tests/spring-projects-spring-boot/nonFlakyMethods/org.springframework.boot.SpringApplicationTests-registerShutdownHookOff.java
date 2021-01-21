@Test public void registerShutdownHookOff() throws Exception {
  SpringApplication application=new SpringApplication(ExampleConfig.class);
  application.setApplicationContextClass(SpyApplicationContext.class);
  application.setRegisterShutdownHook(false);
  this.context=application.run();
  SpyApplicationContext applicationContext=(SpyApplicationContext)this.context;
  verify(applicationContext.getApplicationContext(),never()).registerShutdownHook();
}
