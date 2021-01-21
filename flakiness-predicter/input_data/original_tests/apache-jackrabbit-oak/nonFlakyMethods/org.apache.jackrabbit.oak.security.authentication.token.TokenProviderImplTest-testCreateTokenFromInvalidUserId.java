@Test public void testCreateTokenFromInvalidUserId() throws Exception {
  TokenInfo info=tokenProvider.createToken("unknownUserId",Collections.<String,Object>emptyMap());
  assertNull(info);
}
