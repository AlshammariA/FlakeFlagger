@Test public void testTestSessionGetEffectivePoliciesByPrincipal() throws Exception {
  NodeUtil child=new NodeUtil(root.getTree(testPath)).addChild("child",JcrConstants.NT_UNSTRUCTURED);
  String childPath=child.getTree().getPath();
  Privilege[] privs=privilegesFromNames(PrivilegeConstants.JCR_READ,PrivilegeConstants.JCR_READ_ACCESS_CONTROL);
  setupPolicy(testPath,privs);
  setupPolicy(childPath,privs);
  root.commit();
  Root testRoot=getTestRoot();
  testRoot.refresh();
  JackrabbitAccessControlManager testAcMgr=getTestAccessControlManager();
  AccessControlPolicy[] effective=testAcMgr.getEffectivePolicies(Collections.singleton(getTestPrincipal()));
  assertNotNull(effective);
  assertEquals(2,effective.length);
}
