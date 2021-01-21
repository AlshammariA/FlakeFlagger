@Test public void testImportInvalidImpersonationIgnore() throws Exception {
  List<String> invalid=new ArrayList<String>();
  invalid.add("anybody");
  invalid.add("administrators");
  invalid.add("t");
  for (  String principalName : invalid) {
    String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<sv:node sv:name=\"t\" xmlns:mix=\"http://www.jcp.org/jcr/mix/1.0\" xmlns:nt=\"http://www.jcp.org/jcr/nt/1.0\" xmlns:fn_old=\"http://www.w3.org/2004/10/xpath-functions\" xmlns:fn=\"http://www.w3.org/2005/xpath-functions\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:sv=\"http://www.jcp.org/jcr/sv/1.0\" xmlns:rep=\"internal\" xmlns:jcr=\"http://www.jcp.org/jcr/1.0\">" + "   <sv:property sv:name=\"jcr:primaryType\" sv:type=\"Name\"><sv:value>rep:User</sv:value></sv:property>"+ "   <sv:property sv:name=\"jcr:uuid\" sv:type=\"String\"><sv:value>e358efa4-89f5-3062-b10d-d7316b65649e</sv:value></sv:property>"+ "   <sv:property sv:name=\"rep:password\" sv:type=\"String\"><sv:value>{sha1}8efd86fb78a56a5145ed7739dcb00c78581c5375</sv:value></sv:property>"+ "   <sv:property sv:name=\"rep:principalName\" sv:type=\"String\"><sv:value>t</sv:value></sv:property><sv:property sv:name=\"rep:impersonators\" sv:type=\"String\"><sv:value>" + principalName + "</sv:value></sv:property>"+ "</sv:node>";
    Subject subj=new Subject();
    subj.getPrincipals().add(new PrincipalImpl(principalName));
    try {
      doImport(getTargetPath(),xml);
      Authorizable a=userMgr.getAuthorizable("t");
      if (!a.isGroup()) {
        Impersonation imp=((User)a).getImpersonation();
        Subject s=new Subject();
        s.getPrincipals().add(new PrincipalImpl(principalName));
        assertFalse(imp.allows(s));
        for (PrincipalIterator it=imp.getImpersonators(); it.hasNext(); ) {
          assertFalse(principalName.equals(it.nextPrincipal().getName()));
        }
      }
 else {
        fail("Importing 't' didn't create a User.");
      }
    }
  finally {
      adminSession.refresh(false);
    }
  }
}
