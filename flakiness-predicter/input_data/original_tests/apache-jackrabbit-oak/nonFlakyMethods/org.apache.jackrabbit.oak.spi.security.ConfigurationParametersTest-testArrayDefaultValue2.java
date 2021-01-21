@Test public void testArrayDefaultValue2(){
  TestObject[] testArray=new TestObject[]{new TestObject("t")};
  TestObject[] result=ConfigurationParameters.EMPTY.getConfigValue("test",new TestObject[0],null);
  assertNotNull(result);
  assertEquals(0,result.length);
  assertArrayEquals(testArray,ConfigurationParameters.EMPTY.getConfigValue("test",testArray,null));
  assertArrayEquals(testArray,ConfigurationParameters.EMPTY.getConfigValue("test",testArray,TestObject[].class));
  ConfigurationParameters options=ConfigurationParameters.of(Collections.singletonMap("test",testArray));
  assertArrayEquals(testArray,(TestObject[])options.getConfigValue("test",null,null));
  assertArrayEquals(testArray,options.getConfigValue("test",null,TestObject[].class));
  assertArrayEquals(testArray,options.getConfigValue("test",new TestObject[]{new TestObject("s")},null));
  assertArrayEquals(testArray,options.getConfigValue("test",new TestObject[]{new TestObject("s")},TestObject[].class));
}
