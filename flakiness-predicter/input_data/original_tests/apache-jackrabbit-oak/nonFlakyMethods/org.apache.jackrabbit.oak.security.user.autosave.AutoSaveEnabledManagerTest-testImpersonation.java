@Test public void testImpersonation() throws Exception {
  User u=mgr.createUser("u","u");
  Impersonation imp=u.getImpersonation();
  Principal p=mgr.getAuthorizable("anonymous").getPrincipal();
  assertTrue(imp.grantImpersonation(p));
  assertFalse(root.hasPendingChanges());
  assertTrue(imp.revokeImpersonation(p));
  assertFalse(root.hasPendingChanges());
}
