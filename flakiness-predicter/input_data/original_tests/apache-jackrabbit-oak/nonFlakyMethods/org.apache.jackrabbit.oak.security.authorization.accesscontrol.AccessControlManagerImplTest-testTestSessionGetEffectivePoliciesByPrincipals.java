@Test public void testTestSessionGetEffectivePoliciesByPrincipals() throws Exception {
  NodeUtil child=new NodeUtil(root.getTree(testPath)).addChild("child",JcrConstants.NT_UNSTRUCTURED);
  String childPath=child.getTree().getPath();
  Privilege[] privs=privilegesFromNames(PrivilegeConstants.JCR_READ,PrivilegeConstants.JCR_READ_ACCESS_CONTROL);
  setupPolicy(testPath,privilegesFromNames(PrivilegeConstants.JCR_READ,PrivilegeConstants.JCR_READ_ACCESS_CONTROL));
  JackrabbitAccessControlList acl=getApplicablePolicy(childPath);
  acl.addEntry(EveryonePrincipal.getInstance(),privs,true);
  acMgr.setPolicy(childPath,acl);
  root.commit();
  Root testRoot=getTestRoot();
  testRoot.refresh();
  JackrabbitAccessControlManager testAcMgr=getTestAccessControlManager();
  Set<Principal> principals=ImmutableSet.of(getTestPrincipal(),EveryonePrincipal.getInstance());
  AccessControlPolicy[] policies=testAcMgr.getEffectivePolicies(principals);
  assertNotNull(policies);
  assertEquals(2,policies.length);
}
