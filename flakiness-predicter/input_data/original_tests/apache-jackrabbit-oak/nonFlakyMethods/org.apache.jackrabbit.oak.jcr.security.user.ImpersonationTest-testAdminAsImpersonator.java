@Test public void testAdminAsImpersonator() throws RepositoryException, NotExecutableException {
  String adminId=superuser.getUserID();
  Authorizable admin=userMgr.getAuthorizable(adminId);
  if (admin == null || admin.isGroup() || !((User)admin).isAdmin()) {
    throw new NotExecutableException(adminId + " is not administators ID");
  }
  Principal adminPrincipal=admin.getPrincipal();
  Impersonation impersonation=user.getImpersonation();
  assertFalse(impersonation.grantImpersonation(adminPrincipal));
  assertFalse(impersonation.revokeImpersonation(adminPrincipal));
  assertTrue(impersonation.allows(buildSubject(adminPrincipal)));
  Impersonation adminImpersonation=((User)admin).getImpersonation();
  assertFalse(adminImpersonation.grantImpersonation(adminPrincipal));
  assertFalse(adminImpersonation.revokeImpersonation(adminPrincipal));
  assertTrue(impersonation.allows(buildSubject(adminPrincipal)));
}
