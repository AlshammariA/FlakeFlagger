@Test public void testRemove7() throws Exception {
  Privilege[] rmChildNodes=privilegesFromName(Privilege.JCR_REMOVE_CHILD_NODES);
  Privilege[] rmNode=privilegesFromName(Privilege.JCR_REMOVE_NODE);
  deny(path,privilegesFromName(Privilege.JCR_REMOVE_CHILD_NODES));
  allow(childNPath,rmNode);
  assertFalse(testSession.hasPermission(childNPath,Session.ACTION_REMOVE));
  allow(childNPath,rmChildNodes);
  assertFalse(testSession.hasPermission(childNPath,javax.jcr.Session.ACTION_REMOVE));
  assertTrue(testAcMgr.hasPrivileges(childNPath,new Privilege[]{rmChildNodes[0],rmNode[0]}));
  try {
    testSession.getNode(childNPath).remove();
    testSession.save();
    fail("Removal must fail");
  }
 catch (  AccessDeniedException e) {
  }
}
