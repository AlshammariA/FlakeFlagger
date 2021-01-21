@Test public void specifically_exclude_control_chars() throws UnsupportedEncodingException {
  for (int i=0; i < 32; ++i) {
    final Map<String,String> inMap=new HashMap<String,String>(1);
    final String s=Arrays.toString(Character.toChars(i));
    inMap.put("a",s);
    final String data=encode(inMap);
    assertFalse(data.contains(s));
    final Map<String,String> outMap=new HashMap<String,String>(1);
    decode(outMap,data);
    assertEquals(1,outMap.size());
    assertEquals(s,outMap.get("a"));
  }
}
