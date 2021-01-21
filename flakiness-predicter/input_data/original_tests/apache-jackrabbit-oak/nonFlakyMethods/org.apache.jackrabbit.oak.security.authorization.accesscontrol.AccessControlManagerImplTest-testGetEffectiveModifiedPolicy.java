@Test public void testGetEffectiveModifiedPolicy() throws Exception {
  ACL acl=setupPolicy(testPath);
  AccessControlEntry[] aces=acl.getAccessControlEntries();
  root.commit();
  acl.addAccessControlEntry(EveryonePrincipal.getInstance(),privilegesFromNames(PrivilegeConstants.JCR_VERSION_MANAGEMENT));
  acMgr.setPolicy(testPath,acl);
  AccessControlPolicy[] policies=acMgr.getEffectivePolicies(testPath);
  assertNotNull(policies);
  assertEquals(1,policies.length);
  assertTrue(policies[0] instanceof AccessControlList);
  AccessControlEntry[] effectiveAces=((AccessControlList)policies[0]).getAccessControlEntries();
  assertArrayEquals(aces,effectiveAces);
  assertFalse(Arrays.equals(effectiveAces,acl.getAccessControlEntries()));
}
