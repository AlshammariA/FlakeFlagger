@Test public void testGetPrivilegeFromName() throws AccessControlException, RepositoryException {
  Privilege p=privilegeManager.getPrivilege(Privilege.JCR_VERSION_MANAGEMENT);
  assertTrue(p != null);
  assertEquals(PrivilegeConstants.JCR_VERSION_MANAGEMENT,p.getName());
  assertFalse(p.isAggregate());
  p=privilegeManager.getPrivilege(Privilege.JCR_WRITE);
  assertTrue(p != null);
  assertEquals(PrivilegeConstants.JCR_WRITE,p.getName());
  assertTrue(p.isAggregate());
}
