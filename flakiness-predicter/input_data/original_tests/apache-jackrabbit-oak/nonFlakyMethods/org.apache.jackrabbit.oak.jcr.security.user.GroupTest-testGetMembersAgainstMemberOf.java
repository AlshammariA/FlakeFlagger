@Test public void testGetMembersAgainstMemberOf() throws NotExecutableException, RepositoryException {
  Iterator<Authorizable> it=group.getMembers();
  while (it.hasNext()) {
    Authorizable auth=it.next();
    assertTrueMemberOfContainsGroup(auth.memberOf(),group);
  }
}
