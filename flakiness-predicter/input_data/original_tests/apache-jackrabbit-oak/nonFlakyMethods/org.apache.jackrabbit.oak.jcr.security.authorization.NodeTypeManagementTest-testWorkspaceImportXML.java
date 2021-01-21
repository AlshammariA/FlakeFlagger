@Test public void testWorkspaceImportXML() throws Exception {
  Workspace wsp=testSession.getWorkspace();
  String parentPath=childNode.getPath();
  try {
    wsp.importXML(parentPath,getXmlForImport(),ImportUUIDBehavior.IMPORT_UUID_CREATE_NEW);
    fail("Missing write privilege.");
  }
 catch (  AccessDeniedException e) {
  }
  modify(parentPath,Privilege.JCR_WRITE,true);
  try {
    wsp.importXML(parentPath,getXmlForImport(),ImportUUIDBehavior.IMPORT_UUID_CREATE_NEW);
    fail("Missing privilege jcr:nodeTypeManagement.");
  }
 catch (  AccessDeniedException e) {
  }
  modify(parentPath,REP_WRITE,true);
  wsp.importXML(parentPath,getXmlForImport(),ImportUUIDBehavior.IMPORT_UUID_CREATE_NEW);
}
