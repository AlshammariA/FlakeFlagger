@Test public void bake_in_a_header_a_Unicode_value() throws UnsupportedEncodingException {
  final Map<String,String> inMap=new HashMap<String,String>(1);
  inMap.put("a","\u0000");
  final String data=encode(inMap);
  final Map<String,String> outMap=new HashMap<String,String>(1);
  decode(outMap,data);
  assertEquals(1,outMap.size(),1);
  assertEquals("\u0000",outMap.get("a"));
}
