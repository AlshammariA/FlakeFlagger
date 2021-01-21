@Test public void shouldCreateOverridenManagerFactoryWhenManagerClassPropertyIsMissing(){
  victim=new DefaultWroManagerFactory(new Properties()){
    @Override protected WroManagerFactory newManagerFactory(){
      return new ConfigurableWroManagerFactory();
    }
  }
;
  assertEquals(ConfigurableWroManagerFactory.class,victim.getFactory().getClass());
}
