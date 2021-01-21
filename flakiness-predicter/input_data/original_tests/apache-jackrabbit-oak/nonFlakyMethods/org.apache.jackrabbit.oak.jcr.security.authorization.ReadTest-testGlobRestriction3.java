@Test public void testGlobRestriction3() throws Exception {
  Group group2=getUserManager(superuser).createGroup("group2");
  Group group3=getUserManager(superuser).createGroup("group3");
  superuser.save();
  try {
    Privilege[] readPrivs=privilegesFromName(Privilege.JCR_READ);
    allow(path,group2.getPrincipal(),readPrivs);
    deny(path,group3.getPrincipal(),readPrivs);
    modify(path,getTestGroup().getPrincipal(),readPrivs,true,createGlobRestriction("/*"));
    Set<Principal> principals=new HashSet<Principal>();
    principals.add(getTestGroup().getPrincipal());
    principals.add(group2.getPrincipal());
    principals.add(group3.getPrincipal());
    assertFalse(((JackrabbitAccessControlManager)acMgr).hasPrivileges(path,principals,readPrivs));
    assertTrue(((JackrabbitAccessControlManager)acMgr).hasPrivileges(childNPath,principals,readPrivs));
  }
  finally {
    group2.remove();
    group3.remove();
    superuser.save();
  }
}
