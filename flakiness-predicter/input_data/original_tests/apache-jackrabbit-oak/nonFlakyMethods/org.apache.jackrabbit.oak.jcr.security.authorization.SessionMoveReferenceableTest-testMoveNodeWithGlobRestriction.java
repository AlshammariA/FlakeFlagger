@Test public void testMoveNodeWithGlobRestriction() throws Exception {
  deny(childNPath,readPrivileges,createGlobRestriction('/' + nodeName3));
  assertFalse(testSession.nodeExists(nodePath3));
  assertHasPrivileges(nodePath3,readPrivileges,false);
  String movedChildNPath=path + "/movedNode";
  String movedNode3Path=movedChildNPath + '/' + nodeName3;
  move(childNPath,movedChildNPath,superuser);
  assertFalse(testSession.nodeExists(movedNode3Path));
  assertHasPrivileges(movedNode3Path,readPrivileges,false);
}
