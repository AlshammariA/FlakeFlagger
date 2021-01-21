/** 
 * @since OAK 1.0
 */
@Test public void testTestSessionGetEffectivePolicies2() throws Exception {
  NodeUtil child=new NodeUtil(root.getTree(testPath)).addChild("child",JcrConstants.NT_UNSTRUCTURED);
  String childPath=child.getTree().getPath();
  setupPolicy(testPath,privilegesFromNames(PrivilegeConstants.JCR_READ));
  setupPolicy(childPath,privilegesFromNames(PrivilegeConstants.JCR_READ_ACCESS_CONTROL));
  root.commit();
  Root testRoot=getTestRoot();
  testRoot.refresh();
  AccessControlManager testAcMgr=getTestAccessControlManager();
  assertTrue(testAcMgr.hasPrivileges(childPath,privilegesFromNames(PrivilegeConstants.JCR_READ,PrivilegeConstants.JCR_READ_ACCESS_CONTROL)));
  AccessControlPolicy[] effective=testAcMgr.getEffectivePolicies(childPath);
  assertNotNull(effective);
  assertEquals(1,effective.length);
}
