@Test public void testPut(){
  final CacheKey key=new CacheKey("g1",ResourceType.JS,true);
  final String value="value";
  strategy.put(key,value);
  Assert.assertEquals(value,strategy.get(key));
}
