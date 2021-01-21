public void testAutoSave() throws RepositoryException, NotExecutableException {
  if (userMgr.isAutoSave()) {
    try {
      userMgr.autoSave(false);
    }
 catch (    RepositoryException e) {
      throw new NotExecutableException();
    }
  }
  Principal p=getTestPrincipal();
  String uid=p.getName();
  User user=userMgr.createUser(uid,"pw");
  String gid=createGroupId();
  Group group=userMgr.createGroup(gid);
  superuser.refresh(false);
  assertNull(userMgr.getAuthorizable(uid));
  assertNull(userMgr.getAuthorizable(p));
  assertNull(userMgr.getAuthorizable(gid));
}
