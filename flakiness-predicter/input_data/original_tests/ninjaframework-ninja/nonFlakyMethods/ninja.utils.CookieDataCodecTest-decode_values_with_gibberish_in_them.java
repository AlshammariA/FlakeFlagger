@Test public void decode_values_with_gibberish_in_them() throws UnsupportedEncodingException {
  final String data="asfjdlkasjdflk";
  final Map<String,String> outMap=new HashMap<String,String>(1);
  decode(outMap,data);
  assertEquals(0,outMap.size());
}
