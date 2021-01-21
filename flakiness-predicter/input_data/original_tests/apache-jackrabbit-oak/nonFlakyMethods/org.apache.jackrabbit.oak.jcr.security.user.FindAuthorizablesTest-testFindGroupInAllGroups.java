@Test public void testFindGroupInAllGroups() throws RepositoryException, NotExecutableException {
  Group gr=null;
  try {
    Principal p=getTestPrincipal();
    gr=userMgr.createGroup(p);
    superuser.save();
    boolean found=false;
    Iterator<Authorizable> it=userMgr.findAuthorizables(UserConstants.REP_PRINCIPAL_NAME,null,UserManager.SEARCH_TYPE_GROUP);
    while (it.hasNext() && !found) {
      Group ng=(Group)it.next();
      found=ng.getPrincipal().getName().equals(p.getName());
    }
    assertTrue("Searching for 'null' must find the created group.",found);
  }
  finally {
    if (gr != null) {
      gr.remove();
      superuser.save();
    }
  }
}
