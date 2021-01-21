@Test public void testSessionImportXML() throws Exception {
  String parentPath=childNode.getPath();
  try {
    testSession.importXML(parentPath,getXmlForImport(),ImportUUIDBehavior.IMPORT_UUID_CREATE_NEW);
    testSession.save();
    fail("Missing write privilege.");
  }
 catch (  AccessDeniedException e) {
  }
 finally {
    testSession.refresh(false);
  }
  modify(parentPath,Privilege.JCR_WRITE,true);
  try {
    testSession.importXML(parentPath,getXmlForImport(),ImportUUIDBehavior.IMPORT_UUID_CREATE_NEW);
    testSession.save();
    fail("Missing privilege jcr:nodeTypeManagement.");
  }
 catch (  AccessDeniedException e) {
  }
 finally {
    testSession.refresh(false);
  }
  modify(parentPath,REP_WRITE,true);
  testSession.importXML(parentPath,getXmlForImport(),ImportUUIDBehavior.IMPORT_UUID_CREATE_NEW);
  testSession.save();
}
