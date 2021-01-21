@Test public void testRemove9() throws Exception {
  Privilege[] rmChildNodes=privilegesFromName(Privilege.JCR_REMOVE_CHILD_NODES);
  Privilege[] rmNode=privilegesFromName(Privilege.JCR_REMOVE_NODE);
  allow(path,rmChildNodes);
  allow(childNPath,rmNode);
  String policyPath=childNPath + "/rep:policy";
  assertFalse(testSession.hasPermission(policyPath,Session.ACTION_REMOVE));
  assertHasPrivileges(policyPath,new Privilege[]{rmChildNodes[0],rmNode[0]},false);
}
