@Test public void testPropertiesBoundInGuice(){
  final NinjaPropertiesImpl props=new NinjaPropertiesImpl(NinjaMode.dev);
  MockService service=Guice.createInjector(new AbstractModule(){
    @Override protected void configure(){
      props.bindProperties(binder());
    }
  }
).getInstance(MockService.class);
  assertNotNull("Application secret not set by Guice",service.applicationSecret);
  assertEquals("secret",service.applicationSecret);
}
