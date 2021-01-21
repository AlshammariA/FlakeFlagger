/** 
 * @since OAK 1.0 : RepositoryException is thrown instead of AuthorizableExistsException
 */
public void testCreateTwiceWithSamePrincipal() throws RepositoryException, NotExecutableException {
  Principal p=getTestPrincipal();
  String uid=p.getName();
  User user=createUser(uid,"pw",p,"a/b/c");
  createdUsers.add(user);
  try {
    uid=getTestPrincipal().getName();
    User user2=createUser(uid,"pw",p,null);
    createdUsers.add(user2);
    fail("Creating 2 users with the same Principal should throw AuthorizableExistsException.");
  }
 catch (  RepositoryException e) {
  }
}
