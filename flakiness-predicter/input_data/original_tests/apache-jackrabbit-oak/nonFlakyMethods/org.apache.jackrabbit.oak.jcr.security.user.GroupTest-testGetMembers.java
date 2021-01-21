@Test public void testGetMembers() throws NotExecutableException, RepositoryException {
  Iterator<Authorizable> it=group.getMembers();
  assertNotNull(it);
  while (it.hasNext()) {
    assertTrue(it.next() != null);
  }
}
