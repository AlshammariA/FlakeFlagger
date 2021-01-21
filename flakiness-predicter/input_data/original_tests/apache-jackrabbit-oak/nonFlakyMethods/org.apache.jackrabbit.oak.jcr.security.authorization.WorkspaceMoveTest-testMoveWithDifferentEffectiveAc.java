@Test public void testMoveWithDifferentEffectiveAc() throws Exception {
  deny(path,readPrivileges);
  allow(childNPath,readPrivileges);
  assertTrue(testSession.nodeExists(nodePath3));
  assertTrue(testAcMgr.hasPrivileges(nodePath3,readPrivileges));
  String movedPath=path + "/movedNode";
  move(nodePath3,movedPath,superuser);
  assertFalse(testSession.nodeExists(movedPath));
  assertHasPrivileges(movedPath,readPrivileges,false);
}
