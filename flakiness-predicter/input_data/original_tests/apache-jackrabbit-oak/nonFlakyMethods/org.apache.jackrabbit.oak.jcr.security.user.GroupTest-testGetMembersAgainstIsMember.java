@Test public void testGetMembersAgainstIsMember() throws NotExecutableException, RepositoryException {
  Iterator<Authorizable> it=group.getMembers();
  while (it.hasNext()) {
    Authorizable auth=it.next();
    assertTrue(group.isMember(auth));
  }
}
