/** 
 * @since OAK 1.0 In contrast to Jackrabbit core the intermediate path maynot be an absolute path in OAK.
 */
@Test public void testCreateGroupWithAbsolutePath() throws RepositoryException, NotExecutableException {
  Principal p=getTestPrincipal();
  try {
    Group gr=createGroup(p,"/any/path/to/the/new/group");
    createdGroups.add(gr);
    fail("ConstraintViolationException expected.");
  }
 catch (  ConstraintViolationException e) {
  }
}
