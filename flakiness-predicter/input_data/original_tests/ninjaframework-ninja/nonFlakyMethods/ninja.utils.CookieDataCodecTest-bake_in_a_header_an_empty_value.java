@Test public void bake_in_a_header_an_empty_value() throws UnsupportedEncodingException {
  final Map<String,String> inMap=new HashMap<String,String>(1);
  inMap.put("a","");
  final String data=encode(inMap);
  final Map<String,String> outMap=new HashMap<String,String>(1);
  decode(outMap,data);
  assertEquals(1,outMap.size());
  assertEquals("",outMap.get("a"));
}
