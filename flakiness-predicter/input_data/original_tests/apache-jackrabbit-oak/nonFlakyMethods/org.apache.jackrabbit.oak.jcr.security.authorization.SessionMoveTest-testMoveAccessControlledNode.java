@Test public void testMoveAccessControlledNode() throws Exception {
  deny(childNPath,readPrivileges);
  assertFalse(testSession.nodeExists(childNPath));
  assertHasPrivileges(childNPath,readPrivileges,false);
  assertFalse(testSession.nodeExists(nodePath3));
  assertHasPrivileges(nodePath3,readPrivileges,false);
  String movedChildNPath=path + "/movedNode";
  String movedNode3Path=movedChildNPath + '/' + nodeName3;
  move(childNPath,movedChildNPath,superuser);
  assertFalse(testSession.nodeExists(movedChildNPath));
  assertHasPrivileges(movedChildNPath,readPrivileges,false);
  assertFalse(testSession.nodeExists(movedNode3Path));
  assertHasPrivileges(movedNode3Path,readPrivileges,false);
}
