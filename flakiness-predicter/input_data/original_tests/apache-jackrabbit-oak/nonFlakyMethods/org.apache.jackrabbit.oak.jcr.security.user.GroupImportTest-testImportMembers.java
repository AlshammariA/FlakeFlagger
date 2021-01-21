@Test public void testImportMembers() throws Exception {
  Authorizable admin=checkNotNull(userMgr.getAuthorizable(UserConstants.DEFAULT_ADMIN_ID));
  String uuid=adminSession.getNode(admin.getPath()).getUUID();
  String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<sv:node sv:name=\"gFolder\" xmlns:mix=\"http://www.jcp.org/jcr/mix/1.0\" xmlns:nt=\"http://www.jcp.org/jcr/nt/1.0\" xmlns:fn_old=\"http://www.w3.org/2004/10/xpath-functions\" xmlns:fn=\"http://www.w3.org/2005/xpath-functions\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:sv=\"http://www.jcp.org/jcr/sv/1.0\" xmlns:rep=\"internal\" xmlns:jcr=\"http://www.jcp.org/jcr/1.0\">" + "   <sv:property sv:name=\"jcr:primaryType\" sv:type=\"Name\"><sv:value>rep:AuthorizableFolder</sv:value></sv:property>"+ "   <sv:node sv:name=\"g1\">"+ "       <sv:property sv:name=\"jcr:primaryType\" sv:type=\"Name\"><sv:value>rep:Group</sv:value></sv:property>"+ "       <sv:property sv:name=\"jcr:uuid\" sv:type=\"String\"><sv:value>0120a4f9-196a-3f9e-b9f5-23f31f914da7</sv:value></sv:property>"+ "       <sv:property sv:name=\"rep:principalName\" sv:type=\"String\"><sv:value>g1</sv:value></sv:property>"+ "       <sv:property sv:name=\"rep:members\" sv:type=\"WeakReference\"><sv:value>" + uuid + "</sv:value></sv:property>"+ "   </sv:node>"+ "</sv:node>";
  doImport(getTargetPath(),xml);
  Group g1=(Group)userMgr.getAuthorizable("g1");
  assertNotNull(g1);
  adminSession.save();
  assertTrue(g1.isMember(admin));
  boolean found=false;
  for (Iterator<Group> it=admin.declaredMemberOf(); it.hasNext() && !found; ) {
    found="g1".equals(it.next().getID());
  }
  assertTrue(found);
}
