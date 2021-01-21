@Test public void testGetNullableConfigValue(){
  Map<String,String> map=new HashMap<String,String>();
  map.put("o1","v");
  ConfigurationParameters options=ConfigurationParameters.of(map);
  assertEquals("v",options.getConfigValue("o1",null,null));
  assertEquals("v",options.getConfigValue("o1",null,String.class));
  assertEquals("v",options.getConfigValue("o1","v2",null));
  assertEquals("v",options.getConfigValue("o1","v2",String.class));
  assertEquals("v2",options.getConfigValue("missing","v2",null));
  assertEquals("v2",options.getConfigValue("missing","v2",String.class));
  assertNull(options.getConfigValue("missing",null,null));
  assertNull(options.getConfigValue("missing",null,TestObject.class));
}
