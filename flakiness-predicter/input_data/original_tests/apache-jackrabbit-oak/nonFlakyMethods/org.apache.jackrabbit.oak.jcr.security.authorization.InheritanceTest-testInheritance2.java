@Test public void testInheritance2() throws Exception {
  Privilege[] privileges=privilegesFromNames(new String[]{Privilege.JCR_WRITE});
  allow(path,privileges);
  deny(childNPath,privileges);
  assertFalse(testAcMgr.hasPrivileges(childNPath,privileges));
  String actions=getActions(Session.ACTION_SET_PROPERTY,Session.ACTION_REMOVE,Session.ACTION_ADD_NODE);
  String nonExistingItemPath=childNPath + "/anyItem";
  assertFalse(testSession.hasPermission(nonExistingItemPath,actions));
  Node grandChild=superuser.getNode(childNPath).addNode(nodeName3);
  superuser.save();
  testSession.refresh(false);
  String gcPath=grandChild.getPath();
  allow(gcPath,privileges);
  assertTrue(testAcMgr.hasPrivileges(gcPath,privileges));
  assertTrue(testSession.hasPermission(gcPath + "/anyProp",Session.ACTION_SET_PROPERTY));
  assertFalse(testSession.hasPermission(gcPath,Session.ACTION_REMOVE));
}
