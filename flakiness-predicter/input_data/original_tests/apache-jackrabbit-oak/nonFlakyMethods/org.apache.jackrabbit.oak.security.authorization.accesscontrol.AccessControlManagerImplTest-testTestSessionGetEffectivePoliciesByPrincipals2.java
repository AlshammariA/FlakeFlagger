/** 
 * @since OAK 1.0 : only accessible policies are returned but not exceptionis raised.
 */
@Test public void testTestSessionGetEffectivePoliciesByPrincipals2() throws Exception {
  NodeUtil child=new NodeUtil(root.getTree(testPath)).addChild("child",JcrConstants.NT_UNSTRUCTURED);
  String childPath=child.getTree().getPath();
  Privilege[] privs=privilegesFromNames(PrivilegeConstants.JCR_READ,PrivilegeConstants.JCR_READ_ACCESS_CONTROL);
  JackrabbitAccessControlList acl=getApplicablePolicy(testPath);
  acl.addEntry(getTestPrincipal(),privs,false);
  acMgr.setPolicy(testPath,acl);
  setupPolicy(childPath,privilegesFromNames(PrivilegeConstants.JCR_READ,PrivilegeConstants.JCR_READ_ACCESS_CONTROL));
  root.commit();
  Root testRoot=getTestRoot();
  testRoot.refresh();
  JackrabbitAccessControlManager testAcMgr=getTestAccessControlManager();
  Set<Principal> principals=ImmutableSet.of(getTestPrincipal(),EveryonePrincipal.getInstance());
  AccessControlPolicy[] policies=testAcMgr.getEffectivePolicies(principals);
  assertNotNull(policies);
  assertEquals(1,policies.length);
}
