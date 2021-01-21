/** 
 * @since oak 1.0 : if collision is added within the same set of transientmodifications it will only be detected upon save. in this case RepositoryException is thrown instead of AuthorizableExistsException as the violation is detected by the uniqueness constraint on the corresponding property index.
 */
@Test public void testCreateGroupWithExistingPrincipal4() throws RepositoryException, NotExecutableException {
  Principal p=getTestPrincipal();
  String uid=createUserId();
  assertFalse(uid.equals(p.getName()));
  User u=null;
  Group gr=null;
  try {
    u=userMgr.createUser(uid,"pw",p,null);
    gr=userMgr.createGroup(createGroupId(),p,null);
    superuser.save();
    fail("Principal " + p.getName() + " is already in use -> must throw AuthorizableExistsException.");
  }
 catch (  RepositoryException e) {
  }
 finally {
    if (gr != null) {
      gr.remove();
    }
    if (u != null) {
      u.remove();
    }
    if (superuser.hasPendingChanges()) {
      superuser.save();
    }
  }
}
