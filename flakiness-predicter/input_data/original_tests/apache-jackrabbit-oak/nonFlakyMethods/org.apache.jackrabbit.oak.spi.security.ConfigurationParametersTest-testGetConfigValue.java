@Test public void testGetConfigValue(){
  Map<String,String> map=new HashMap<String,String>();
  map.put("o1","v");
  ConfigurationParameters options=ConfigurationParameters.of(map);
  assertEquals("v",options.getConfigValue("o1","v2"));
  assertEquals("v2",options.getConfigValue("missing","v2"));
}
