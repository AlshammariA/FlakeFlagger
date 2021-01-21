@Test public void decode_values_of_the_previously_supported_format_with_the_new_delimiters_in_them() throws UnsupportedEncodingException {
  final Map<String,String> inMap=new HashMap<String,String>(1);
  inMap.put("a","b&=");
  final String data=oldEncoder(inMap);
  final Map<String,String> outMap=new HashMap<String,String>(0);
  decode(outMap,data);
  assertEquals(0,outMap.size());
}
