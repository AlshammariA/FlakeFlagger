@Test public void testInheritance() throws Exception {
  Privilege[] privileges=privilegesFromNames(new String[]{Privilege.JCR_REMOVE_NODE,Privilege.JCR_MODIFY_PROPERTIES});
  allow(path,privileges);
  privileges=privilegesFromNames(new String[]{Privilege.JCR_ADD_CHILD_NODES,Privilege.JCR_REMOVE_CHILD_NODES});
  allow(childNPath,privileges);
  Privilege[] expectedPrivileges=privilegesFromNames(new String[]{Privilege.JCR_READ,Privilege.JCR_ADD_CHILD_NODES,Privilege.JCR_REMOVE_CHILD_NODES,Privilege.JCR_REMOVE_NODE,Privilege.JCR_MODIFY_PROPERTIES});
  assertTrue(testAcMgr.hasPrivileges(childNPath,expectedPrivileges));
  String aActions=javax.jcr.Session.ACTION_SET_PROPERTY + ',' + javax.jcr.Session.ACTION_READ;
  assertTrue(testSession.hasPermission(childNPath,aActions));
  String dActions=javax.jcr.Session.ACTION_REMOVE + ',' + javax.jcr.Session.ACTION_ADD_NODE;
  assertFalse(testSession.hasPermission(childNPath,dActions));
  String nonExistingItemPath=childNPath + "/anyItem";
  assertTrue(testSession.hasPermission(nonExistingItemPath,aActions + ',' + dActions));
  Node childN=testSession.getNode(childNPath);
  String testPath=childN.addNode(nodeName2).getPath();
  assertTrue(testAcMgr.hasPrivileges(testPath,expectedPrivileges));
  testSession.save();
  assertTrue(testAcMgr.hasPrivileges(testPath,expectedPrivileges));
}
