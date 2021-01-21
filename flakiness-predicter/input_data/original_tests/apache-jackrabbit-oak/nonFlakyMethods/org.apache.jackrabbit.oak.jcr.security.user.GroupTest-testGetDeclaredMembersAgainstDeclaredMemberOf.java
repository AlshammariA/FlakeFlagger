@Test public void testGetDeclaredMembersAgainstDeclaredMemberOf() throws NotExecutableException, RepositoryException {
  Iterator<Authorizable> it=group.getDeclaredMembers();
  while (it.hasNext()) {
    Authorizable auth=it.next();
    assertTrueMemberOfContainsGroup(auth.declaredMemberOf(),group);
  }
}
