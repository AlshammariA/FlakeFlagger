@Test public void testRemoveToken() throws Exception {
  TokenInfo info=tokenProvider.createToken(userId,Collections.<String,Object>emptyMap());
  assertTrue(info.remove());
}
