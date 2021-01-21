@Test public void shouldHaveNoCacheHeadersInDebugMode(){
  final WroConfiguration config=new WroConfiguration();
  config.setDebug(true);
  victim=ResponseHeadersConfigurer.fromConfig(config);
  final Map<String,String> map=victim.getHeadersMap();
  assertEquals(3,map.size());
  assertEquals("no-cache",map.get(HttpHeader.PRAGMA.getHeaderName()));
  assertEquals("no-cache",map.get(HttpHeader.CACHE_CONTROL.getHeaderName()));
  assertEquals("0",map.get(HttpHeader.EXPIRES.getHeaderName()));
}
