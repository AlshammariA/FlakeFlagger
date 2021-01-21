/** 
 * Removing an authorizable that is still listed as member of a group.
 * @throws javax.jcr.RepositoryException
 * @throws org.apache.jackrabbit.test.NotExecutableException
 */
public void testRemoveListedAuthorizable() throws RepositoryException, NotExecutableException {
  String newUserId=null;
  Group newGroup=null;
  try {
    Principal uP=getTestPrincipal();
    User newUser=userMgr.createUser(uP.getName(),uP.getName());
    superuser.save();
    newUserId=newUser.getID();
    newGroup=userMgr.createGroup(getTestPrincipal());
    newGroup.addMember(newUser);
    superuser.save();
    newUser.remove();
    superuser.save();
  }
  finally {
    if (newUserId != null) {
      Authorizable u=userMgr.getAuthorizable(newUserId);
      if (u != null) {
        if (newGroup != null) {
          newGroup.removeMember(u);
        }
        u.remove();
      }
    }
    if (newGroup != null) {
      newGroup.remove();
    }
    superuser.save();
  }
}
