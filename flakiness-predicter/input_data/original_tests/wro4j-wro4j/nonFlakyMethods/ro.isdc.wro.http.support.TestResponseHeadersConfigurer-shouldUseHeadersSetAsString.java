@Test public void shouldUseHeadersSetAsString(){
  victim=ResponseHeadersConfigurer.withHeadersSet("h1:v1 | h2:v2");
  final Map<String,String> map=victim.getHeadersMap();
  assertEquals("v1",map.get("h1"));
  assertEquals("v2",map.get("h2"));
  assertEquals(2,map.size());
}
