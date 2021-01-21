@Test public void decode_values_of_the_previously_supported_format() throws UnsupportedEncodingException {
  final Map<String,String> inMap=new HashMap<String,String>(2);
  inMap.put("a","b");
  inMap.put("c","d");
  final String data=oldEncoder(inMap);
  final Map<String,String> outMap=new HashMap<String,String>(0);
  decode(outMap,data);
  assertEquals(0,outMap.size());
}
