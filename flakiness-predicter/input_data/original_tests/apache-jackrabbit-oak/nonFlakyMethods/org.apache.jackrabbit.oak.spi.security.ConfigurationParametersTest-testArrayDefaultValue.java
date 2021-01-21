@Test public void testArrayDefaultValue(){
  TestObject[] testArray=new TestObject[]{new TestObject("t")};
  TestObject[] result=ConfigurationParameters.EMPTY.getConfigValue("test",new TestObject[0]);
  assertNotNull(result);
  assertEquals(0,result.length);
  assertArrayEquals(testArray,ConfigurationParameters.EMPTY.getConfigValue("test",testArray));
  ConfigurationParameters options=ConfigurationParameters.of(Collections.singletonMap("test",testArray));
  assertArrayEquals(testArray,options.getConfigValue("test",new TestObject[]{new TestObject("s")}));
}
