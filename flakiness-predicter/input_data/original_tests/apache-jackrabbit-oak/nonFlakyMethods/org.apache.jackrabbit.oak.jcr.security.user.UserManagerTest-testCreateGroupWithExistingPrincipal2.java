@Test public void testCreateGroupWithExistingPrincipal2() throws RepositoryException, NotExecutableException {
  Principal p=getTestPrincipal();
  String uid=createUserId();
  assertFalse(uid.equals(p.getName()));
  User u=null;
  try {
    u=userMgr.createUser(uid,"pw",p,null);
    superuser.save();
    Group gr=null;
    try {
      gr=userMgr.createGroup(p);
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
