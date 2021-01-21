@Test public void testGetPrivileges() throws RepositoryException {
  ACE entry=createEntry(new String[]{PrivilegeConstants.JCR_READ},true);
  Privilege[] privs=entry.getPrivileges();
  assertNotNull(privs);
  assertEquals(1,privs.length);
  assertEquals(privs[0],acMgr.privilegeFromName(PrivilegeConstants.JCR_READ));
  entry=createEntry(new String[]{PrivilegeConstants.REP_WRITE},true);
  privs=entry.getPrivileges();
  assertNotNull(privs);
  assertEquals(1,privs.length);
  assertEquals(privs[0],acMgr.privilegeFromName(PrivilegeConstants.REP_WRITE));
  entry=createEntry(new String[]{PrivilegeConstants.JCR_ADD_CHILD_NODES,PrivilegeConstants.JCR_REMOVE_CHILD_NODES},true);
  privs=entry.getPrivileges();
  assertNotNull(privs);
  assertEquals(2,privs.length);
  Privilege[] expected=AccessControlUtils.privilegesFromNames(acMgr,PrivilegeConstants.JCR_ADD_CHILD_NODES,PrivilegeConstants.JCR_REMOVE_CHILD_NODES);
  assertEquals(ImmutableSet.copyOf(expected),ImmutableSet.copyOf(privs));
}
