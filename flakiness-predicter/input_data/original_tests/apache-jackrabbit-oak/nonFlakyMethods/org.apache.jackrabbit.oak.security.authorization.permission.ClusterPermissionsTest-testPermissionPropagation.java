@Test public void testPermissionPropagation() throws Exception {
  Tree node=root1.getTree("/").addChild("testNode");
  node.setProperty("jcr:primaryType","nt:unstructured");
  User user1=userManager1.createUser("testUser1","testUser1");
  User user2=userManager1.createUser("testUser2","testUser2");
  JackrabbitAccessControlList acl1=AccessControlUtils.getAccessControlList(aclMgr1,"/testNode");
  acl1.addEntry(EveryonePrincipal.getInstance(),AccessControlUtils.privilegesFromNames(aclMgr1,"jcr:all"),false);
  acl1.addEntry(user1.getPrincipal(),AccessControlUtils.privilegesFromNames(aclMgr1,"jcr:read"),true);
  aclMgr1.setPolicy("/testNode",acl1);
  root1.commit();
  syncClusterNodes();
  root2.refresh();
  ContentSession session1=contentRepository2.login(new SimpleCredentials("testUser1","testUser1".toCharArray()),null);
  ContentSession session2=contentRepository2.login(new SimpleCredentials("testUser2","testUser2".toCharArray()),null);
  assertTrue(session1.getLatestRoot().getTree("/testNode").exists());
  assertFalse(session2.getLatestRoot().getTree("/testNode").exists());
  acl1=AccessControlUtils.getAccessControlList(aclMgr1,"/testNode");
  acl1.addEntry(EveryonePrincipal.getInstance(),AccessControlUtils.privilegesFromNames(aclMgr1,"jcr:read"),true);
  aclMgr1.setPolicy("/testNode",acl1);
  root1.commit();
  syncClusterNodes();
  root2.refresh();
  assertTrue(session1.getLatestRoot().getTree("/testNode").exists());
  assertTrue(session2.getLatestRoot().getTree("/testNode").exists());
}
