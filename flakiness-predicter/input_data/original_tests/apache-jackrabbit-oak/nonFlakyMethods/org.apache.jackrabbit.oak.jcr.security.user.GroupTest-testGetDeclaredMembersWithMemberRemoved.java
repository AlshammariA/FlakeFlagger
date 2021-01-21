@Test public void testGetDeclaredMembersWithMemberRemoved() throws RepositoryException {
  String uid=user.getID();
  user.remove();
  superuser.save();
  user=null;
  Iterator<Authorizable> it=group.getDeclaredMembers();
  while (it.hasNext()) {
    Authorizable a=it.next();
    assertFalse(uid.equals(a.getID()));
  }
}
