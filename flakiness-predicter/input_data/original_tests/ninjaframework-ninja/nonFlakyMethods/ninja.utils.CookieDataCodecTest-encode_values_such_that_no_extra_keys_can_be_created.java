@Test public void encode_values_such_that_no_extra_keys_can_be_created() throws UnsupportedEncodingException {
  final Map<String,String> inMap=new HashMap<String,String>(1);
  inMap.put("a","b&c=d");
  final String data=encode(inMap);
  final Map<String,String> outMap=new HashMap<String,String>(1);
  decode(outMap,data);
  assertEquals(1,outMap.size());
  assertEquals("b&c=d",outMap.get("a"));
}
