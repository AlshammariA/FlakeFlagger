@Test public void testAccessControlActionExecutionForUser() throws Exception {
  AccessControlAction a1=new AccessControlAction();
  a1.init(securityProvider,ConfigurationParameters.of(Collections.singletonMap(AccessControlAction.USER_PRIVILEGE_NAMES,new String[]{Privilege.JCR_ALL})));
  setAuthorizableActions(a1);
  String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<sv:node sv:name=\"t\" xmlns:mix=\"http://www.jcp.org/jcr/mix/1.0\" xmlns:nt=\"http://www.jcp.org/jcr/nt/1.0\" xmlns:fn_old=\"http://www.w3.org/2004/10/xpath-functions\" xmlns:fn=\"http://www.w3.org/2005/xpath-functions\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:sv=\"http://www.jcp.org/jcr/sv/1.0\" xmlns:rep=\"internal\" xmlns:jcr=\"http://www.jcp.org/jcr/1.0\">" + "   <sv:property sv:name=\"jcr:primaryType\" sv:type=\"Name\"><sv:value>rep:User</sv:value></sv:property>"+ "   <sv:property sv:name=\"jcr:uuid\" sv:type=\"String\"><sv:value>e358efa4-89f5-3062-b10d-d7316b65649e</sv:value></sv:property>"+ "   <sv:property sv:name=\"rep:password\" sv:type=\"String\"><sv:value>{sha1}8efd86fb78a56a5145ed7739dcb00c78581c5375</sv:value></sv:property>"+ "   <sv:property sv:name=\"rep:principalName\" sv:type=\"String\"><sv:value>tPrincipal</sv:value></sv:property>"+ "</sv:node>";
  doImport(USERPATH,xml);
  Authorizable a=userMgr.getAuthorizable("t");
  assertNotNull(a);
  assertFalse(a.isGroup());
  AccessControlManager acMgr=adminSession.getAccessControlManager();
  AccessControlPolicy[] policies=acMgr.getPolicies(a.getPath());
  assertNotNull(policies);
  assertEquals(1,policies.length);
  assertTrue(policies[0] instanceof AccessControlList);
  AccessControlEntry[] aces=((AccessControlList)policies[0]).getAccessControlEntries();
  assertEquals(1,aces.length);
  assertEquals("tPrincipal",aces[0].getPrincipal().getName());
}
