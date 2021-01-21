/** 
 * @since OAK 1.0
 */
@Test public void testTestSessionGetEffectivePolicies() throws Exception {
  Privilege[] privileges=privilegesFromNames(PrivilegeConstants.JCR_READ,PrivilegeConstants.JCR_READ_ACCESS_CONTROL);
  setupPolicy(testPath,privileges);
  root.commit();
  Root testRoot=getTestRoot();
  testRoot.refresh();
  AccessControlManager testAcMgr=getTestAccessControlManager();
  assertTrue(testAcMgr.hasPrivileges(testPath,privileges));
  AccessControlPolicy[] effective=testAcMgr.getEffectivePolicies(testPath);
  assertNotNull(effective);
  assertEquals(1,effective.length);
}
