@Test public void flash_cookies_should_bake_in_a_header_and_value() throws UnsupportedEncodingException {
  final Map<String,String> inMap=new HashMap<String,String>(1);
  inMap.put("a","b");
  final String data=encode(inMap);
  final Map<String,String> outMap=new HashMap<String,String>(1);
  decode(outMap,data);
  assertEquals(1,outMap.size());
  assertEquals("b",outMap.get("a"));
}
