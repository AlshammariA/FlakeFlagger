@Test public void testCreateUserWithNullPrincipal() throws RepositoryException {
  try {
    Principal p=getTestPrincipal();
    String uid=p.getName();
    User user=createUser(uid,"pw",null,"/a/b/c");
    createdUsers.add(user);
    fail("A User cannot be built with 'null' Principal");
  }
 catch (  Exception e) {
  }
}
