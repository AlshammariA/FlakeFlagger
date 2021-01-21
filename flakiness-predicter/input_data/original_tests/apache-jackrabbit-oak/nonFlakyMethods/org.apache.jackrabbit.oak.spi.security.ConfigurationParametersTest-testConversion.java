@Test public void testConversion(){
  TestObject testObject=new TestObject("t");
  Integer int1000=1000;
  Map<String,Object> m=new HashMap<String,Object>();
  m.put("TEST",testObject);
  m.put("String","1000");
  m.put("Int2",1000);
  m.put("Int3",1000);
  m.put("time0","1s");
  m.put("time1",1000);
  ConfigurationParameters options=ConfigurationParameters.of(m);
  assertEquals(testObject,options.getConfigValue("TEST",testObject));
  assertEquals("t",options.getConfigValue("TEST","defaultString"));
  assertTrue(1000 == options.getConfigValue("String",10,int.class));
  assertTrue(1000 == options.getConfigValue("String",10));
  assertEquals(int1000,options.getConfigValue("String",10));
  assertEquals(new Long(1000),options.getConfigValue("String",10l));
  assertEquals("1000",options.getConfigValue("String","10"));
  assertEquals(int1000,options.getConfigValue("Int2",10));
  assertEquals("1000",options.getConfigValue("Int2","1000"));
  assertEquals(int1000,options.getConfigValue("Int3",10));
  assertEquals("1000",options.getConfigValue("Int3","1000"));
  assertEquals(ConfigurationParameters.Milliseconds.of(1000),options.getConfigValue("time0",ConfigurationParameters.Milliseconds.NULL));
  assertEquals(ConfigurationParameters.Milliseconds.of(1000),options.getConfigValue("time1",ConfigurationParameters.Milliseconds.NULL));
}
