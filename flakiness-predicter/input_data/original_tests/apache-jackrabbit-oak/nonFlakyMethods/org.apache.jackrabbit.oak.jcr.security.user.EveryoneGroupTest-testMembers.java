@Test public void testMembers() throws RepositoryException, NotExecutableException {
  assertTrue(everyone.isDeclaredMember(getTestUser(superuser)));
  assertTrue(everyone.isMember(getTestUser(superuser)));
  Iterator<Authorizable> it=everyone.getDeclaredMembers();
  assertTrue(it.hasNext());
  Set<Authorizable> members=new HashSet<Authorizable>();
  while (it.hasNext()) {
    members.add(it.next());
  }
  it=everyone.getMembers();
  assertTrue(it.hasNext());
  while (it.hasNext()) {
    assertTrue(members.contains(it.next()));
  }
}
