@Test public void testRetrievePrivilegesOnAcNodes() throws Exception {
  Privilege[] privileges=privilegesFromName(Privilege.JCR_READ_ACCESS_CONTROL);
  allow(path,privileges);
  assertTrue(testAcMgr.hasPrivileges(path,privileges));
  AccessControlPolicy[] policies=testAcMgr.getPolicies(path);
  assertEquals(1,policies.length);
  assertTrue(policies[0] instanceof JackrabbitAccessControlList);
  String aclNodePath=null;
  Node n=superuser.getNode(path);
  for (NodeIterator itr=n.getNodes(); itr.hasNext(); ) {
    Node child=itr.nextNode();
    if (child.isNodeType("rep:Policy")) {
      aclNodePath=child.getPath();
    }
  }
  if (aclNodePath == null) {
    fail("Expected node at " + path + " to have an ACL child node.");
  }
  assertTrue(testAcMgr.hasPrivileges(aclNodePath,privileges));
  assertTrue(testSession.hasPermission(aclNodePath,Session.ACTION_READ));
  for (NodeIterator aceNodes=superuser.getNode(aclNodePath).getNodes(); aceNodes.hasNext(); ) {
    String aceNodePath=aceNodes.nextNode().getPath();
    assertTrue(testAcMgr.hasPrivileges(aceNodePath,privileges));
    assertTrue(testSession.hasPermission(aceNodePath,Session.ACTION_READ));
  }
}
