@Test public void testContains(){
  ConfigurationParameters params=ConfigurationParameters.EMPTY;
  assertFalse(params.contains("some"));
  assertFalse(params.contains(""));
  Map<String,String> map=new HashMap<String,String>();
  map.put("key1","v");
  map.put("key2","v");
  params=ConfigurationParameters.of(map);
  assertTrue(params.contains("key1"));
  assertTrue(params.contains("key2"));
  assertFalse(params.contains("another"));
  assertFalse(params.contains(""));
}
