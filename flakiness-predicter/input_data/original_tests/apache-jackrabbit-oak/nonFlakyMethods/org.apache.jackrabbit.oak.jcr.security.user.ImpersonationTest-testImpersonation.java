@Test public void testImpersonation() throws RepositoryException, NotExecutableException {
  Principal user2Principal=user2.getPrincipal();
  Subject subject=new Subject(true,Collections.singleton(user2Principal),Collections.<Object>emptySet(),Collections.<Object>emptySet());
  Impersonation impers=user.getImpersonation();
  assertFalse(impers.allows(subject));
  assertTrue(impers.grantImpersonation(user2Principal));
  assertFalse(impers.grantImpersonation(user2Principal));
  superuser.save();
  assertTrue(impers.allows(subject));
  assertTrue(impers.revokeImpersonation(user2Principal));
  assertFalse(impers.revokeImpersonation(user2Principal));
  superuser.save();
  assertFalse(impers.allows(subject));
}
