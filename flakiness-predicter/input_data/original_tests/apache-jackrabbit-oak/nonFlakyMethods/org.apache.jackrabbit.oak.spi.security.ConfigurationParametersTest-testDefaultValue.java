@Test public void testDefaultValue(){
  TestObject obj=new TestObject("t");
  Integer int1000=1000;
  ConfigurationParameters options=ConfigurationParameters.EMPTY;
  assertEquals(obj,options.getConfigValue("missing",obj));
  assertEquals(int1000,options.getConfigValue("missing",int1000));
  assertNull(options.getConfigValue("missing",null,null));
  assertNull(options.getConfigValue("missing",null,String.class));
  assertEquals(obj,options.getConfigValue("missing",obj,null));
  assertEquals(obj,options.getConfigValue("missing",obj,TestObject.class));
  assertEquals(int1000,options.getConfigValue("missing",int1000,Integer.class));
}
