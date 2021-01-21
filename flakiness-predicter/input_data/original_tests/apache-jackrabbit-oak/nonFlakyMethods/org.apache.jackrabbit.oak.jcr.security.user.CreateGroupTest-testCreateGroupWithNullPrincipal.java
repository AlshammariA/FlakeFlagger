@Test public void testCreateGroupWithNullPrincipal() throws RepositoryException {
  try {
    Group gr=createGroup(null);
    createdGroups.add(gr);
    fail("A Group cannot be built from 'null' Principal");
  }
 catch (  Exception e) {
  }
  try {
    Group gr=createGroup(null,"/any/path/to/the/new/group");
    createdGroups.add(gr);
    fail("A Group cannot be built from 'null' Principal");
  }
 catch (  Exception e) {
  }
}
