@Test public void testCreateUser() throws RepositoryException, NotExecutableException {
  Principal p=getTestPrincipal();
  String uid=p.getName();
  User user=createUser(uid,"pw");
  createdUsers.add(user);
  assertNotNull(user.getID());
  assertEquals(p.getName(),user.getPrincipal().getName());
}
