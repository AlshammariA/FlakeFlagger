@Test public void testCreateWithIntermediateReadDeny() throws Exception {
  String path=UserConstants.DEFAULT_GROUP_PATH + "/a/b/c";
  Node groupRoot=JcrUtils.getOrCreateByPath(path,UserConstants.NT_REP_AUTHORIZABLE_FOLDER,superuser);
  superuser.save();
  try {
    deny(UserConstants.DEFAULT_GROUP_PATH,privilegesFromName(Privilege.JCR_READ));
    Privilege[] privs=privilegesFromNames(new String[]{Privilege.JCR_READ,PrivilegeConstants.REP_USER_MANAGEMENT,PrivilegeConstants.REP_WRITE});
    allow(path,privs);
    Group gr=getUserManager(testSession).createGroup(groupId,new PrincipalImpl(groupId),"a/b/c");
    testSession.save();
  }
  finally {
    superuser.refresh(false);
    superuser.getNode(UserConstants.DEFAULT_GROUP_PATH + "/a").remove();
    JackrabbitAccessControlList acl=AccessControlUtils.getAccessControlList(acMgr,UserConstants.DEFAULT_GROUP_PATH);
    if (acl != null) {
      acMgr.removePolicy(UserConstants.DEFAULT_GROUP_PATH,acl);
    }
    superuser.save();
  }
}
