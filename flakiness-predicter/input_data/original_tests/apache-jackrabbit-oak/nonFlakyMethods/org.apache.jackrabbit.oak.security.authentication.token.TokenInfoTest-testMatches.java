@Test public void testMatches(){
  TokenInfo info=tokenProvider.createToken(userId,Collections.<String,Object>emptyMap());
  assertTrue(info.matches(new TokenCredentials(info.getToken())));
  Map<String,String> attributes=new HashMap<String,String>();
  attributes.put("something","value");
  info=tokenProvider.createToken(userId,attributes);
  assertTrue(info.matches(new TokenCredentials(info.getToken())));
  attributes.put(".token-something","mandatory");
  info=tokenProvider.createToken(userId,attributes);
  assertFalse(info.matches(new TokenCredentials(info.getToken())));
  TokenCredentials tc=new TokenCredentials(info.getToken());
  tc.setAttribute(".token-something","mandatory");
  assertTrue(info.matches(tc));
  tc.setAttribute("another","value");
  assertTrue(info.matches(tc));
  tc.setAttribute(".token_ignored","value");
  assertTrue(info.matches(tc));
}
