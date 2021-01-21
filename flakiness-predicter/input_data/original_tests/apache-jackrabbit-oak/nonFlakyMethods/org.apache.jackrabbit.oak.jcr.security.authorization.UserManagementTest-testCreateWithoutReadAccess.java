@Test public void testCreateWithoutReadAccess() throws Exception {
  UserManager testUserMgr=getUserManager(testSession);
  deny("/",privilegesFromName(PrivilegeConstants.JCR_READ));
  allow("/",privilegesFromName(PrivilegeConstants.REP_USER_MANAGEMENT));
  try {
    Group gr=testUserMgr.createGroup(groupId);
    testSession.save();
    fail("Creating group without read-access on the folder node should fail");
  }
 catch (  AccessDeniedException e) {
  }
}
