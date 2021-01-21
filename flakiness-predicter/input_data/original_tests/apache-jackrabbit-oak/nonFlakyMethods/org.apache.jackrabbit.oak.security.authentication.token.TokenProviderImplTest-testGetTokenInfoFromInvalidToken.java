@Test public void testGetTokenInfoFromInvalidToken() throws Exception {
  List<String> invalid=new ArrayList<String>();
  invalid.add("/invalid");
  invalid.add(UUID.randomUUID().toString());
  for (  String token : invalid) {
    TokenInfo info=tokenProvider.getTokenInfo(token);
    assertNull(info);
  }
  try {
    assertNull(tokenProvider.getTokenInfo("invalidToken"));
  }
 catch (  Exception e) {
  }
}
