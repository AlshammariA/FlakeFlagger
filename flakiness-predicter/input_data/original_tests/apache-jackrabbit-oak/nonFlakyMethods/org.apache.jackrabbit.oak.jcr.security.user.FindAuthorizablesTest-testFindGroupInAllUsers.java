@Test public void testFindGroupInAllUsers() throws RepositoryException, NotExecutableException {
  Group gr=null;
  try {
    Principal p=getTestPrincipal();
    gr=userMgr.createGroup(p);
    superuser.save();
    boolean found=false;
    Iterator<Authorizable> it=userMgr.findAuthorizables(UserConstants.REP_PRINCIPAL_NAME,null,UserManager.SEARCH_TYPE_USER);
    while (it.hasNext()) {
      if (it.next().getPrincipal().getName().equals(p.getName())) {
        fail("Searching for Users should never find a group");
      }
    }
  }
  finally {
    if (gr != null) {
      gr.remove();
      superuser.save();
    }
  }
}
