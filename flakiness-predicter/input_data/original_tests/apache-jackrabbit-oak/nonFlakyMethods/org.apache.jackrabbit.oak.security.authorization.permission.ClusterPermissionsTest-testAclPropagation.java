@Test public void testAclPropagation() throws Exception {
  Tree node=root1.getTree("/").addChild("testNode");
  node.setProperty("jcr:primaryType","nt:unstructured");
  User user1=userManager1.createUser("testUser","testUser");
  JackrabbitAccessControlList acl1=AccessControlUtils.getAccessControlList(aclMgr1,"/testNode");
  acl1.addEntry(user1.getPrincipal(),AccessControlUtils.privilegesFromNames(aclMgr1,"jcr:all"),true);
  aclMgr1.setPolicy("/testNode",acl1);
  root1.commit();
  syncClusterNodes();
  root2.refresh();
  JackrabbitAccessControlList acl2=AccessControlUtils.getAccessControlList(aclMgr2,"/testNode");
  AccessControlEntry[] aces=acl2.getAccessControlEntries();
  assertEquals(1,aces.length);
}
