@Test public void testImportGroup() throws Exception {
  String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<sv:node sv:name=\"g\" xmlns:mix=\"http://www.jcp.org/jcr/mix/1.0\" xmlns:nt=\"http://www.jcp.org/jcr/nt/1.0\" xmlns:fn_old=\"http://www.w3.org/2004/10/xpath-functions\" xmlns:fn=\"http://www.w3.org/2005/xpath-functions\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:sv=\"http://www.jcp.org/jcr/sv/1.0\" xmlns:rep=\"internal\" xmlns:jcr=\"http://www.jcp.org/jcr/1.0\">" + "   <sv:property sv:name=\"jcr:primaryType\" sv:type=\"Name\"><sv:value>rep:Group</sv:value></sv:property>"+ "   <sv:property sv:name=\"jcr:uuid\" sv:type=\"String\"><sv:value>b2f5ff47-4366-31b6-a533-d8dc3614845d</sv:value></sv:property>"+ "   <sv:property sv:name=\"rep:principalName\" sv:type=\"String\"><sv:value>g</sv:value></sv:property>"+ "</sv:node>";
  Node target=getTargetNode();
  doImport(getTargetPath(),xml);
  assertTrue(target.isModified());
  assertTrue(adminSession.hasPendingChanges());
  Authorizable newGroup=userMgr.getAuthorizable("g");
  assertNotNull(newGroup);
  assertTrue(newGroup.isGroup());
  assertEquals("g",newGroup.getPrincipal().getName());
  assertEquals("g",newGroup.getID());
  Node n=adminSession.getNode(newGroup.getPath());
  assertTrue(n.isNew());
  assertTrue(n.getParent().isSame(target));
  assertEquals("g",n.getName());
  assertEquals("g",n.getProperty(UserConstants.REP_PRINCIPAL_NAME).getString());
  adminSession.save();
}
