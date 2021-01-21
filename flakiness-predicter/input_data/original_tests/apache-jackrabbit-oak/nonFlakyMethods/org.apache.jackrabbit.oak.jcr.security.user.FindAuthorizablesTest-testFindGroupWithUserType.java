@Test public void testFindGroupWithUserType() throws RepositoryException, NotExecutableException {
  Group gr=null;
  try {
    Principal p=getTestPrincipal();
    gr=userMgr.createGroup(p);
    superuser.save();
    Iterator<Authorizable> it=userMgr.findAuthorizables(UserConstants.REP_PRINCIPAL_NAME,p.getName(),UserManager.SEARCH_TYPE_USER);
    assertFalse(it.hasNext());
  }
  finally {
    if (gr != null) {
      gr.remove();
      superuser.save();
    }
  }
}
