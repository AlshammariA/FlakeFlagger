@Test public void testCreateGroupWithExistingGroupID() throws RepositoryException, NotExecutableException {
  Group g=null;
  try {
    String id=createGroupId();
    g=userMgr.createGroup(id);
    superuser.save();
    Group gr=null;
    try {
      gr=userMgr.createGroup(id);
      fail("ID " + id + " is already in use -> must throw AuthorizableExistsException.");
    }
 catch (    AuthorizableExistsException aee) {
    }
 finally {
      if (gr != null) {
        gr.remove();
        superuser.save();
      }
    }
  }
  finally {
    if (g != null) {
      g.remove();
      superuser.save();
    }
  }
}
