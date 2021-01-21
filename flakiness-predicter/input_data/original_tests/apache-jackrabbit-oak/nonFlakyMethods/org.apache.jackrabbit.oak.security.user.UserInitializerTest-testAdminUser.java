@Test public void testAdminUser() throws Exception {
  Authorizable a=userMgr.getAuthorizable(UserUtil.getAdminId(config));
  assertFalse(a.isGroup());
  User admin=(User)a;
  assertTrue(admin.isAdmin());
  assertTrue(admin.getPrincipal() instanceof AdminPrincipal);
  assertTrue(admin.getPrincipal() instanceof TreeBasedPrincipal);
  assertEquals(admin.getID(),admin.getPrincipal().getName());
}
