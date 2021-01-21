/** 
 * @since OAK 1.0 Policy at testPath not accessible -> getEffectivePoliciesonly returns the readable policy but doesn't fail.
 */
@Test public void testTestSessionGetEffectivePoliciesByPrincipal2() throws Exception {
  NodeUtil child=new NodeUtil(root.getTree(testPath)).addChild("child",JcrConstants.NT_UNSTRUCTURED);
  String childPath=child.getTree().getPath();
  setupPolicy(testPath,privilegesFromNames(PrivilegeConstants.JCR_READ_ACCESS_CONTROL));
  setupPolicy(childPath,privilegesFromNames(PrivilegeConstants.JCR_READ,PrivilegeConstants.JCR_READ_ACCESS_CONTROL));
  root.commit();
  Root testRoot=getTestRoot();
  testRoot.refresh();
  JackrabbitAccessControlManager testAcMgr=getTestAccessControlManager();
  AccessControlPolicy[] effective=testAcMgr.getEffectivePolicies(Collections.singleton(getTestPrincipal()));
  assertNotNull(effective);
  assertEquals(1,effective.length);
}
