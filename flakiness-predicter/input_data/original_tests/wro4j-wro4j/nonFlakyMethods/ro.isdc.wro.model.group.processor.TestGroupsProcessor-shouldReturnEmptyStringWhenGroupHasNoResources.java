@Test public void shouldReturnEmptyStringWhenGroupHasNoResources(){
  final CacheKey key=new CacheKey(groupName,ResourceType.JS,true);
  Assert.assertEquals(StringUtils.EMPTY,victim.process(key));
}
