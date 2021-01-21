/** 
 * @since OAK 1.0 In contrast to Jackrabbit core the intermediate path maynot be an absolute path in OAK.
 */
@Test public void testCreateUserWithAbsolutePath() throws RepositoryException, NotExecutableException {
  Principal p=getTestPrincipal();
  String uid=p.getName();
  try {
    User user=createUser(uid,"pw",p,"/any/path/to/the/new/user");
    createdUsers.add(user);
    fail("ConstraintViolationException expected");
  }
 catch (  ConstraintViolationException e) {
  }
}
