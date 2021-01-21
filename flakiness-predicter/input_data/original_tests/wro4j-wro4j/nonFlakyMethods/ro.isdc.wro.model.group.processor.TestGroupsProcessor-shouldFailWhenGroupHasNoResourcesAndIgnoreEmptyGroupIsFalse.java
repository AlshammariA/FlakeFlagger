/** 
 * Same as above, but with ignoreEmptyGroup config updated.
 */
@Test(expected=WroRuntimeException.class) public void shouldFailWhenGroupHasNoResourcesAndIgnoreEmptyGroupIsFalse(){
  final WroConfiguration config=new WroConfiguration();
  config.setIgnoreEmptyGroup(false);
  initVictim(config);
  final CacheKey key=new CacheKey("group",ResourceType.JS,true);
  victim.process(key);
}
