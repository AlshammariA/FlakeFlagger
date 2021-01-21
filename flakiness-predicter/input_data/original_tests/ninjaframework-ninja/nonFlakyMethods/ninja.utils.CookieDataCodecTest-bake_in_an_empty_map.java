@Test public void bake_in_an_empty_map() throws UnsupportedEncodingException {
  final Map<String,String> inMap=new HashMap<String,String>(0);
  final String data=encode(inMap);
  final Map<String,String> outMap=new HashMap<String,String>(1);
  decode(outMap,data);
  assertEquals(0,outMap.size());
}
