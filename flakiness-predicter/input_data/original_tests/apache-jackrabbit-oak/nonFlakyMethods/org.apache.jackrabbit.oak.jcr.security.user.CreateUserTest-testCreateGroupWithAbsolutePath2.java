@Test public void testCreateGroupWithAbsolutePath2() throws RepositoryException, NotExecutableException {
  Principal p=getTestPrincipal();
  String uid=p.getName();
  String userRoot=UserConstants.DEFAULT_USER_PATH;
  String path=userRoot + "/any/path/to/the/new/user";
  User user=createUser(uid,"pw",p,path);
  createdUsers.add(user);
  assertTrue(user.getPath().startsWith(path));
}
