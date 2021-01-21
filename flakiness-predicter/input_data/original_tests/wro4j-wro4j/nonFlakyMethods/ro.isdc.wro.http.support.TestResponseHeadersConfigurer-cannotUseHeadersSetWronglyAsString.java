@Test(expected=WroRuntimeException.class) public void cannotUseHeadersSetWronglyAsString(){
  final WroConfiguration config=new WroConfiguration();
  config.setDebug(true);
  config.setHeader("h1=v1 , h2 =v2");
  victim=ResponseHeadersConfigurer.fromConfig(config);
  final Map<String,String> map=victim.getHeadersMap();
  assertEquals(2,map.size());
  assertEquals("v1",map.get("h1"));
  assertEquals("v2",map.get("h2"));
}
