@Test public void testCreation(){
  ConfigurationParameters params=ConfigurationParameters.of(ConfigurationParameters.EMPTY,null,ConfigurationParameters.of(Collections.singletonMap("a","a")));
  assertFalse(params.isEmpty());
  assertEquals(1,params.size());
  assertTrue(params.contains("a"));
}
