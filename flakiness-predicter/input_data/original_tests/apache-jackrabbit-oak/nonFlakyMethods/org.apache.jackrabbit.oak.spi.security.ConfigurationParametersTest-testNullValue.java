@Test public void testNullValue(){
  ConfigurationParameters options=ConfigurationParameters.of(Collections.singletonMap("test",null));
  assertNull(options.getConfigValue("test",null));
  assertEquals("value",options.getConfigValue("test","value"));
  TestObject to=new TestObject("t");
  assertEquals(to,options.getConfigValue("test",to));
  assertFalse(options.getConfigValue("test",false));
}
