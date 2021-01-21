@Test public void testGetDeclaredMembers() throws NotExecutableException, RepositoryException {
  Iterator<Authorizable> it=group.getDeclaredMembers();
  assertNotNull(it);
  while (it.hasNext()) {
    Authorizable a=it.next();
    assertNotNull(a);
    members.remove(a.getID());
  }
  assertTrue(members.isEmpty());
}
