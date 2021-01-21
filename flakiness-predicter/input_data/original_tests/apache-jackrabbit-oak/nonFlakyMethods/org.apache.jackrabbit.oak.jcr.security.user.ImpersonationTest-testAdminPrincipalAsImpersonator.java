public void testAdminPrincipalAsImpersonator() throws RepositoryException, NotExecutableException {
  Principal adminPrincipal=new AdminPrincipal(){
    @Override public String getName(){
      return "some-admin-name";
    }
  }
;
  Impersonation impersonation=user.getImpersonation();
  assertFalse(impersonation.grantImpersonation(adminPrincipal));
  assertFalse(impersonation.revokeImpersonation(adminPrincipal));
  assertTrue(impersonation.allows(buildSubject(adminPrincipal)));
}
