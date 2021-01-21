@Test public void testNullValue2(){
  ConfigurationParameters options=ConfigurationParameters.of(Collections.singletonMap("test",null));
  assertNull(options.getConfigValue("test",null,null));
  assertNull(options.getConfigValue("test",null,TestObject.class));
  assertNull(options.getConfigValue("test","value",null));
  assertNull(options.getConfigValue("test","value",null));
  assertNull(options.getConfigValue("test",new TestObject("t"),null));
  assertNull(options.getConfigValue("test",false,null));
}
