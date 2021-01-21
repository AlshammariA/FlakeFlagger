@Test public void testCreateUserWithDifferentPrincipalName() throws RepositoryException, NotExecutableException {
  Principal p=getTestPrincipal();
  String uid=getTestPrincipal().getName();
  User user=createUser(uid,"pw",p,"any/path");
  createdUsers.add(user);
  assertNotNull(user.getID());
  assertEquals(p.getName(),user.getPrincipal().getName());
}
