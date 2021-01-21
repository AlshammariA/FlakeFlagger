/** 
 * @see <a href="https://issues.apache.org/jira/browse/JCR-3412">JCR-3412 :
     *      UserManager.findAuthorizables() does not work, if session does not have
     *      read access to common root of all user and groups. </a>
 */
@Test public void testFindAuthorizables() throws Exception {
  String home=Text.getRelativeParent(UserConstants.DEFAULT_USER_PATH,1);
  deny(home,privilegesFromName(PrivilegeConstants.JCR_READ));
  allow(getUserManager(superuser).getAuthorizable(testSession.getUserID()).getPath(),privilegesFromName(PrivilegeConstants.JCR_ALL));
  UserManager testUserMgr=getUserManager(testSession);
  Iterator<Authorizable> result=testUserMgr.findAuthorizables(UserConstants.REP_PRINCIPAL_NAME,null,UserManager.SEARCH_TYPE_USER);
  Set<String> ids=new HashSet<String>();
  while (result.hasNext()) {
    ids.add(result.next().getID());
  }
  assertFalse(ids.isEmpty());
  NodeIterator nodeIterator=testSession.getWorkspace().getQueryManager().createQuery("/jcr:root//element(*,rep:User)",Query.XPATH).execute().getNodes();
  assertTrue(nodeIterator.hasNext());
  while (nodeIterator.hasNext()) {
    String userId=nodeIterator.nextNode().getProperty(UserConstants.REP_AUTHORIZABLE_ID).getString();
    if (!ids.remove(userId)) {
      fail("UserId " + userId + " missing in result set.");
    }
  }
  assertTrue("Result mismatch",ids.isEmpty());
}
