@Test public void testGetMembersContainsDeclaredMembers() throws NotExecutableException, RepositoryException {
  List<String> l=new ArrayList<String>();
  for (Iterator<Authorizable> it=group.getMembers(); it.hasNext(); ) {
    l.add(it.next().getID());
  }
  for (Iterator<Authorizable> it=group.getDeclaredMembers(); it.hasNext(); ) {
    assertTrue("All declared members must also be part of the Iterator " + "returned upon getMembers()",l.contains(it.next().getID()));
  }
}
