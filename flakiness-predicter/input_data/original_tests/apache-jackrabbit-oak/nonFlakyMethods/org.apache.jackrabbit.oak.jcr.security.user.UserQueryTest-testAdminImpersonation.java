@Test public void testAdminImpersonation() throws Exception {
  final String adminPrincipalName=userMgr.getAuthorizable(superuser.getUserID()).getPrincipal().getName();
  Iterator<Authorizable> result=userMgr.findAuthorizables(new Query(){
    public <T>void build(    QueryBuilder<T> builder){
      builder.setCondition(builder.impersonates(adminPrincipalName));
    }
  }
);
  Iterator<Authorizable> expected=userMgr.findAuthorizables(UserConstants.REP_PRINCIPAL_NAME,null,UserManager.SEARCH_TYPE_USER);
  assertTrue(result.hasNext());
  assertSameElements(expected,result);
}
