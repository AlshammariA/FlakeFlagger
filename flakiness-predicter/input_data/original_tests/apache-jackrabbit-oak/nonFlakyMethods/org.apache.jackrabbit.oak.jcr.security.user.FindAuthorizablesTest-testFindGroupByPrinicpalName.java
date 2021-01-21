@Test public void testFindGroupByPrinicpalName() throws RepositoryException, NotExecutableException {
  Group gr=null;
  try {
    Principal p=getTestPrincipal();
    gr=userMgr.createGroup(p);
    superuser.save();
    boolean found=false;
    Iterator<Authorizable> it=userMgr.findAuthorizables(UserConstants.REP_PRINCIPAL_NAME,p.getName(),UserManager.SEARCH_TYPE_GROUP);
    assertTrue(it.hasNext());
    Group ng=(Group)it.next();
    assertEquals("Searching for principal-name must find the created group.",p.getName(),ng.getPrincipal().getName());
    assertFalse("Only a single group must be found for a given principal name.",it.hasNext());
  }
  finally {
    if (gr != null) {
      gr.remove();
      superuser.save();
    }
  }
}
