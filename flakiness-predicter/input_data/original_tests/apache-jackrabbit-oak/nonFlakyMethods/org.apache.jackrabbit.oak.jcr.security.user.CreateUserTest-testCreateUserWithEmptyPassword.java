@Test public void testCreateUserWithEmptyPassword() throws RepositoryException, NotExecutableException {
  Principal p=getTestPrincipal();
  User user=createUser(p.getName(),"");
  createdUsers.add(user);
}
