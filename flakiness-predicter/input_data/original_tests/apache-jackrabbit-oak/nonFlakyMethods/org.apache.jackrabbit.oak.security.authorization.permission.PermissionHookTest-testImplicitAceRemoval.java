@Test public void testImplicitAceRemoval() throws Exception {
  AccessControlManager acMgr=getAccessControlManager(root);
  JackrabbitAccessControlList acl=AccessControlUtils.getAccessControlList(acMgr,testPath);
  acl.addAccessControlEntry(getTestPrincipal(),privilegesFromNames(JCR_READ,REP_WRITE));
  acMgr.setPolicy(testPath,acl);
  acl=AccessControlUtils.getAccessControlList(acMgr,childPath);
  acl.addAccessControlEntry(EveryonePrincipal.getInstance(),privilegesFromNames(JCR_READ));
  acMgr.setPolicy(childPath,acl);
  root.commit();
  assertTrue(root.getTree(childPath + "/rep:policy").exists());
  Tree principalRoot=getPrincipalRoot(EveryonePrincipal.NAME);
  assertEquals(4,cntEntries(principalRoot));
  ContentSession testSession=createTestSession();
  Root testRoot=testSession.getLatestRoot();
  assertTrue(testRoot.getTree(childPath).exists());
  assertFalse(testRoot.getTree(childPath + "/rep:policy").exists());
  testRoot.getTree(childPath).remove();
  testRoot.commit();
  testSession.close();
  root.refresh();
  assertFalse(root.getTree(testPath).hasChild("childNode"));
  assertFalse(root.getTree(childPath + "/rep:policy").exists());
  principalRoot=getPrincipalRoot(EveryonePrincipal.NAME);
  assertEquals(2,cntEntries(principalRoot));
}
