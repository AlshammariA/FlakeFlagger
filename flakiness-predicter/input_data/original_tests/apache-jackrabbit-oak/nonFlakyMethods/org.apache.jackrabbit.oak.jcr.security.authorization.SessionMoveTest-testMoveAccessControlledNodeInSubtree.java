@Test public void testMoveAccessControlledNodeInSubtree() throws Exception {
  deny(nodePath3,readPrivileges);
  assertFalse(testSession.nodeExists(nodePath3));
  assertHasPrivileges(nodePath3,readPrivileges,false);
  String movedChildNPath=path + "/movedNode";
  String movedNode3Path=movedChildNPath + '/' + nodeName3;
  move(childNPath,movedChildNPath,superuser);
  assertFalse(testSession.nodeExists(movedNode3Path));
  assertHasPrivileges(movedNode3Path,readPrivileges,false);
}
