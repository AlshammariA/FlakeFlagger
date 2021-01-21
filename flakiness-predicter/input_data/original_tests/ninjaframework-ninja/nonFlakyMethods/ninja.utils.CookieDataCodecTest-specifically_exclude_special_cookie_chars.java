@Test public void specifically_exclude_special_cookie_chars() throws UnsupportedEncodingException {
  final Map<String,String> inMap=new HashMap<String,String>(1);
  inMap.put("a"," \",;\\");
  final String data=encode(inMap);
  assertFalse(data.contains(" "));
  assertFalse(data.contains("\""));
  assertFalse(data.contains(","));
  assertFalse(data.contains(";"));
  assertFalse(data.contains("\\"));
  final Map<String,String> outMap=new HashMap<String,String>(1);
  decode(outMap,data);
  assertEquals(1,outMap.size());
  assertEquals(" \",;\\",outMap.get("a"));
}
