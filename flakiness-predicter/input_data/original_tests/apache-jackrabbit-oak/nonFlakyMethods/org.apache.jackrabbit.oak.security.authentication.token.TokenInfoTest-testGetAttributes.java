@Test public void testGetAttributes(){
  Map<String,String> reserved=new HashMap<String,String>();
  reserved.put(".token","value");
  reserved.put("rep:token.key","value");
  reserved.put("rep:token.exp","value");
  Map<String,String> privateAttributes=new HashMap<String,String>();
  privateAttributes.put(".token_exp","value");
  privateAttributes.put(".tokenTest","value");
  privateAttributes.put(".token_something","value");
  Map<String,String> publicAttributes=new HashMap<String,String>();
  publicAttributes.put("any","value");
  publicAttributes.put("another","value");
  Map<String,String> attributes=new HashMap<String,String>();
  attributes.putAll(reserved);
  attributes.putAll(publicAttributes);
  attributes.putAll(privateAttributes);
  TokenInfo info=tokenProvider.createToken(userId,attributes);
  Map<String,String> pubAttr=info.getPublicAttributes();
  assertEquals("public attributes",publicAttributes.size(),pubAttr.size());
  for (  String key : publicAttributes.keySet()) {
    assertTrue("public attribute " + key + " not contained",pubAttr.containsKey(key));
    assertEquals("public attribute " + key,publicAttributes.get(key),pubAttr.get(key));
  }
  Map<String,String> privAttr=info.getPrivateAttributes();
  assertEquals("private attributes",privateAttributes.size(),privAttr.size());
  for (  String key : privateAttributes.keySet()) {
    assertTrue("private attribute " + key + " not contained",privAttr.containsKey(key));
    assertEquals("private attribute" + key,privateAttributes.get(key),privAttr.get(key));
  }
  for (  String key : reserved.keySet()) {
    assertFalse("reserved attribute " + key,privAttr.containsKey(key));
    assertFalse("reserved attribute " + key,pubAttr.containsKey(key));
  }
}
