@Test public void testCollectionAsArray() throws Exception {
  String[] testArray={"t"};
  ConfigurationParameters options=ConfigurationParameters.of(Collections.singletonMap("test",Arrays.asList(testArray)));
  assertArrayEquals(testArray,options.getConfigValue("test",null,String[].class));
}
