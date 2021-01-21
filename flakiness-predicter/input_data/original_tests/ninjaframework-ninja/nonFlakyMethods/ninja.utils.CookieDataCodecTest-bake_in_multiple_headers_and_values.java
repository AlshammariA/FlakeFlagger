@Test public void bake_in_multiple_headers_and_values() throws UnsupportedEncodingException {
  final Map<String,String> inMap=new HashMap<String,String>(2);
  inMap.put("a","b");
  inMap.put("c","d");
  final String data=encode(inMap);
  final Map<String,String> outMap=new HashMap<String,String>(1);
  decode(outMap,data);
  assertEquals(outMap.size(),2);
  assertEquals("b",outMap.get("a"));
  assertEquals("d",outMap.get("c"));
}
