@Test public void testAnonymous() throws Exception {
  Authorizable a=userMgr.getAuthorizable(UserUtil.getAnonymousId(config));
  assertFalse(a.isGroup());
  User anonymous=(User)a;
  assertFalse(anonymous.isAdmin());
  assertFalse(anonymous.getPrincipal() instanceof AdminPrincipal);
  assertTrue(anonymous.getPrincipal() instanceof TreeBasedPrincipal);
  assertEquals(anonymous.getID(),anonymous.getPrincipal().getName());
}
