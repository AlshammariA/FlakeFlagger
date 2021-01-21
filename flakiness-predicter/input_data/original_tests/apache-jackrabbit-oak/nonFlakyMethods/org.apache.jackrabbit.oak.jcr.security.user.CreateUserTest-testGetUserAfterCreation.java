public void testGetUserAfterCreation() throws RepositoryException, NotExecutableException {
  Principal p=getTestPrincipal();
  String uid=p.getName();
  User user=createUser(uid,"pw");
  createdUsers.add(user);
  assertNotNull(userMgr.getAuthorizable(user.getID()));
  assertNotNull(userMgr.getAuthorizable(p));
}
