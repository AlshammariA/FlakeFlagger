@Test public void testGetPath() throws Exception {
  deny(path,privilegesFromName(PrivilegeConstants.JCR_READ));
  allow(path,privilegesFromName(PrivilegeConstants.REP_READ_PROPERTIES));
  List<String> propertyPaths=new ArrayList<String>();
  propertyPaths.add(childPPath);
  propertyPaths.add(childchildPPath);
  propertyPaths.add(path + "/jcr:primaryType");
  for (  String pPath : propertyPaths) {
    Property p=testSession.getProperty(pPath);
    assertEquals(pPath,p.getPath());
  }
}
