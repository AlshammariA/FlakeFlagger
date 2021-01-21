@Test public void shouldSetCacheControlForOneYearWhenDebugModeIsFalse(){
  final WroConfiguration config=new WroConfiguration();
  config.setDebug(false);
  victim=ResponseHeadersConfigurer.fromConfig(config);
  final Map<String,String> map=victim.getHeadersMap();
  assertEquals(3,map.size());
  assertEquals("public, max-age=315360000",map.get(HttpHeader.CACHE_CONTROL.getHeaderName()));
}
