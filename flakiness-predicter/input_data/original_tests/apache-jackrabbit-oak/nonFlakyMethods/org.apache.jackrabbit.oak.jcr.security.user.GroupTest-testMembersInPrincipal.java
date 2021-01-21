@Test public void testMembersInPrincipal() throws NotExecutableException, RepositoryException {
  User auth=getTestUser(superuser);
  Group newGroup=null;
  Group newGroup2=null;
  try {
    newGroup=userMgr.createGroup(createGroupId());
    newGroup2=userMgr.createGroup(createGroupId());
    superuser.save();
    newGroup.addMember(newGroup2);
    superuser.save();
    newGroup2.addMember(auth);
    superuser.save();
    java.security.acl.Group ngPrincipal=(java.security.acl.Group)newGroup.getPrincipal();
    java.security.acl.Group ng2Principal=(java.security.acl.Group)newGroup2.getPrincipal();
    assertFalse(ng2Principal.isMember(ngPrincipal));
    assertTrue(ngPrincipal.isMember(newGroup2.getPrincipal()));
    assertTrue(ng2Principal.isMember(auth.getPrincipal()));
    assertTrue(ngPrincipal.isMember(auth.getPrincipal()));
  }
  finally {
    if (newGroup != null) {
      newGroup.removeMember(newGroup2);
      newGroup.remove();
      superuser.save();
    }
    if (newGroup2 != null) {
      newGroup2.removeMember(auth);
      newGroup2.remove();
      superuser.save();
    }
  }
}
