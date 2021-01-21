@Test public void testAddChildNodeAndSetProperty() throws Exception {
  Privilege[] privileges=privilegesFromNames(new String[]{Privilege.JCR_ADD_CHILD_NODES,Privilege.JCR_MODIFY_PROPERTIES});
  allow(path,privileges);
  String nonExChildPath=path + "/anyItem";
  String actions=getActions(Session.ACTION_READ,Session.ACTION_ADD_NODE,Session.ACTION_SET_PROPERTY);
  assertTrue(testSession.hasPermission(nonExChildPath,actions));
  assertFalse(testSession.hasPermission(nonExChildPath,Session.ACTION_REMOVE));
  Node testN=testSession.getNode(path);
  testN.addNode(nodeName4);
  testSession.save();
  testSession.getProperty(childPPath).remove();
  testSession.save();
  testN.setProperty(Text.getName(childPPath),"othervalue");
  testSession.save();
  try {
    testSession.getNode(childNPath).remove();
    testSession.save();
    fail("test-user is not allowed to remove a node below " + path);
  }
 catch (  AccessDeniedException e) {
  }
  assertTrue(testSession.hasPermission(path,Session.ACTION_READ));
  assertFalse(testSession.hasPermission(path,getActions(Session.ACTION_ADD_NODE,Session.ACTION_SET_PROPERTY,Session.ACTION_REMOVE)));
  assertReadOnly(siblingPath);
}
