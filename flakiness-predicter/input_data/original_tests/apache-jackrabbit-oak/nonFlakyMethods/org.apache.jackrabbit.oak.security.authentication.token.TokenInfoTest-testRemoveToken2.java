@Test public void testRemoveToken2() throws Exception {
  TokenInfo info=tokenProvider.createToken(userId,Collections.<String,Object>emptyMap());
  assertTrue(info.remove());
}
