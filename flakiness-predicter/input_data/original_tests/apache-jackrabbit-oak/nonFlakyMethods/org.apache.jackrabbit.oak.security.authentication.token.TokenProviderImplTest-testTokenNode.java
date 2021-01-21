@Test public void testTokenNode() throws Exception {
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
  Tree tokenTree=getTokenTree(info);
  PropertyState prop=tokenTree.getProperty("rep:token.key");
  assertNotNull(prop);
  assertEquals(Type.STRING,prop.getType());
  prop=tokenTree.getProperty("rep:token.exp");
  assertNotNull(prop);
  assertEquals(Type.DATE,prop.getType());
  for (  String key : reserved.keySet()) {
    PropertyState p=tokenTree.getProperty(key);
    if (p != null) {
      assertFalse(reserved.get(key).equals(p.getValue(Type.STRING)));
    }
  }
  for (  String key : privateAttributes.keySet()) {
    assertEquals(privateAttributes.get(key),tokenTree.getProperty(key).getValue(Type.STRING));
  }
  for (  String key : publicAttributes.keySet()) {
    assertEquals(publicAttributes.get(key),tokenTree.getProperty(key).getValue(Type.STRING));
  }
}
