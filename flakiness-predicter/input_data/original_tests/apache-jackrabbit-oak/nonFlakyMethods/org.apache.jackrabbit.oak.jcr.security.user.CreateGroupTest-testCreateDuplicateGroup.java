@Test public void testCreateDuplicateGroup() throws RepositoryException, NotExecutableException {
  Principal p=getTestPrincipal();
  Group gr=createGroup(p);
  createdGroups.add(gr);
  try {
    Group gr2=createGroup(p);
    createdGroups.add(gr2);
    fail("Creating 2 groups with the same Principal should throw AuthorizableExistsException.");
  }
 catch (  AuthorizableExistsException e) {
  }
}
