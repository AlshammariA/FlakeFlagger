@Test public void testCreateGroupWithExistingPrincipal3() throws RepositoryException, NotExecutableException {
  Principal p=getTestPrincipal();
  String uid=createUserId();
  assertFalse(uid.equals(p.getName()));
  User u=null;
  try {
    u=userMgr.createUser(uid,"pw",p,null);
    superuser.save();
    Group gr=null;
    try {
      gr=userMgr.createGroup(createGroupId(),p,null);
      fail("Principal " + p.getName() + " is already in use -> must throw AuthorizableExistsException.");
    }
 catch (    AuthorizableExistsException e) {
    }
 finally {
      if (gr != null) {
        gr.remove();
        superuser.save();
      }
    }
  }
  finally {
    if (u != null) {
      u.remove();
      superuser.save();
    }
  }
}
