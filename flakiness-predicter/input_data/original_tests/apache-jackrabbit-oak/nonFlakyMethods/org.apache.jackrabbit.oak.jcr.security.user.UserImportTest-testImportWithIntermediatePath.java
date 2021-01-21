@Test public void testImportWithIntermediatePath() throws Exception {
  String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<sv:node sv:name=\"some\" xmlns:mix=\"http://www.jcp.org/jcr/mix/1.0\" xmlns:nt=\"http://www.jcp.org/jcr/nt/1.0\" xmlns:fn_old=\"http://www.w3.org/2004/10/xpath-functions\" xmlns:fn=\"http://www.w3.org/2005/xpath-functions\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:sv=\"http://www.jcp.org/jcr/sv/1.0\" xmlns:rep=\"internal\" xmlns:jcr=\"http://www.jcp.org/jcr/1.0\">" + "   <sv:property sv:name=\"jcr:primaryType\" sv:type=\"Name\"><sv:value>rep:AuthorizableFolder</sv:value></sv:property>"+ "   <sv:property sv:name=\"jcr:uuid\" sv:type=\"String\"><sv:value>d5433be9-68d0-4fba-bf96-efc29f461993</sv:value></sv:property>"+ "<sv:node sv:name=\"intermediate\">"+ "   <sv:property sv:name=\"jcr:primaryType\" sv:type=\"Name\"><sv:value>rep:AuthorizableFolder</sv:value></sv:property>"+ "   <sv:property sv:name=\"jcr:uuid\" sv:type=\"String\"><sv:value>d87354a4-037e-4756-a8fb-deb2eb7c5149</sv:value></sv:property>"+ "<sv:node sv:name=\"path\">"+ "   <sv:property sv:name=\"jcr:primaryType\" sv:type=\"Name\"><sv:value>rep:AuthorizableFolder</sv:value></sv:property>"+ "   <sv:property sv:name=\"jcr:uuid\" sv:type=\"String\"><sv:value>24263272-b789-4568-957a-3bcaf99dbab3</sv:value></sv:property>"+ "<sv:node sv:name=\"t3\">"+ "   <sv:property sv:name=\"jcr:primaryType\" sv:type=\"Name\"><sv:value>rep:User</sv:value></sv:property>"+ "   <sv:property sv:name=\"jcr:uuid\" sv:type=\"String\"><sv:value>0b8854ad-38f0-36c6-9807-928d28195609</sv:value></sv:property>"+ "   <sv:property sv:name=\"rep:password\" sv:type=\"String\"><sv:value>{sha1}4358694eeb098c6708ae914a10562ce722bbbc34</sv:value></sv:property>"+ "   <sv:property sv:name=\"rep:principalName\" sv:type=\"String\"><sv:value>t3</sv:value></sv:property>"+ "</sv:node>"+ "</sv:node>"+ "</sv:node>"+ "</sv:node>";
  Node target=getTargetNode();
  doImport(getTargetPath(),xml);
  assertTrue(target.isModified());
  assertTrue(adminSession.hasPendingChanges());
  Authorizable newUser=userMgr.getAuthorizable("t3");
  assertNotNull(newUser);
  assertFalse(newUser.isGroup());
  assertEquals("t3",newUser.getPrincipal().getName());
  assertEquals("t3",newUser.getID());
  Node n=adminSession.getNode(newUser.getPath());
  assertTrue(n.isNew());
  Node parent=n.getParent();
  assertFalse(n.isSame(target));
  assertTrue(parent.isNodeType(UserConstants.NT_REP_AUTHORIZABLE_FOLDER));
  assertFalse(parent.getDefinition().isProtected());
  assertTrue(target.hasNode("some"));
  assertTrue(target.hasNode("some/intermediate/path"));
}
