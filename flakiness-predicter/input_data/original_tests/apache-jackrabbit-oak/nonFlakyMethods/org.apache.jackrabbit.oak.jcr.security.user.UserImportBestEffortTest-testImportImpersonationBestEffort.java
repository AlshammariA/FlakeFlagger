@Test public void testImportImpersonationBestEffort() throws Exception {
  String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<sv:node sv:name=\"uFolder\" xmlns:mix=\"http://www.jcp.org/jcr/mix/1.0\" xmlns:nt=\"http://www.jcp.org/jcr/nt/1.0\" xmlns:fn_old=\"http://www.w3.org/2004/10/xpath-functions\" xmlns:fn=\"http://www.w3.org/2005/xpath-functions\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:sv=\"http://www.jcp.org/jcr/sv/1.0\" xmlns:rep=\"internal\" xmlns:jcr=\"http://www.jcp.org/jcr/1.0\">" + "   <sv:property sv:name=\"jcr:primaryType\" sv:type=\"Name\"><sv:value>rep:AuthorizableFolder</sv:value></sv:property>"+ "<sv:node sv:name=\"t\">"+ "   <sv:property sv:name=\"jcr:primaryType\" sv:type=\"Name\"><sv:value>rep:User</sv:value></sv:property>"+ "   <sv:property sv:name=\"jcr:uuid\" sv:type=\"String\"><sv:value>e358efa4-89f5-3062-b10d-d7316b65649e</sv:value></sv:property>"+ "   <sv:property sv:name=\"rep:principalName\" sv:type=\"String\"><sv:value>t</sv:value></sv:property>"+ "   <sv:property sv:name=\"rep:impersonators\" sv:type=\"String\"><sv:value>g</sv:value></sv:property>"+ "</sv:node>"+ "<sv:node sv:name=\"g\">"+ "   <sv:property sv:name=\"jcr:primaryType\" sv:type=\"Name\"><sv:value>rep:User</sv:value></sv:property>"+ "   <sv:property sv:name=\"jcr:uuid\" sv:type=\"String\"><sv:value>b2f5ff47-4366-31b6-a533-d8dc3614845d</sv:value></sv:property>"+ "   <sv:property sv:name=\"rep:principalName\" sv:type=\"String\"><sv:value>g</sv:value></sv:property>"+ "</sv:node>"+ "</sv:node>";
  doImport(getTargetPath(),xml);
  Authorizable newUser=userMgr.getAuthorizable("t");
  assertNotNull(newUser);
  Authorizable u2=userMgr.getAuthorizable("g");
  assertNotNull(u2);
  Subject subj=new Subject();
  subj.getPrincipals().add(u2.getPrincipal());
  Impersonation imp=((User)newUser).getImpersonation();
  assertTrue(imp.allows(subj));
}
