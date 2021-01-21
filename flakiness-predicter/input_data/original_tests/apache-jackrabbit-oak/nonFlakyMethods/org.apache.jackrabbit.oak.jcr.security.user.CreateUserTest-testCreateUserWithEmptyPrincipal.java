public void testCreateUserWithEmptyPrincipal() throws RepositoryException {
  try {
    Principal p=getTestPrincipal("");
    String uid=p.getName();
    User user=createUser(uid,"pw",p,"/a/b/c");
    createdUsers.add(user);
    fail("A User cannot be built with ''-named Principal");
  }
 catch (  Exception e) {
  }
  try {
    Principal p=getTestPrincipal(null);
    String uid=p.getName();
    User user=createUser(uid,"pw",p,"/a/b/c");
    createdUsers.add(user);
    fail("A User cannot be built with ''-named Principal");
  }
 catch (  Exception e) {
  }
}
