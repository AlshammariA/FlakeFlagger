@Test public void testCreationFromNull(){
  ConfigurationParameters cp=null;
  ConfigurationParameters params=ConfigurationParameters.of(new ConfigurationParameters[]{cp});
  assertSame(ConfigurationParameters.EMPTY,params);
}
