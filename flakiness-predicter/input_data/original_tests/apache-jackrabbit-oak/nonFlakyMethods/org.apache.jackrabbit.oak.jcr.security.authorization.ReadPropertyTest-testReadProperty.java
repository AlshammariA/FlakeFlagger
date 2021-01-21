@Test public void testReadProperty() throws Exception {
  deny(path,privilegesFromName(PrivilegeConstants.JCR_READ));
  allow(path,privilegesFromName(PrivilegeConstants.REP_READ_PROPERTIES));
  assertFalse(testSession.nodeExists(path));
  assertFalse(testSession.itemExists(path));
  assertFalse(testSession.nodeExists(childNPath));
  List<String> propertyPaths=new ArrayList<String>();
  propertyPaths.add(childPPath);
  propertyPaths.add(childchildPPath);
  propertyPaths.add(path + "/jcr:primaryType");
  for (  String pPath : propertyPaths) {
    assertTrue(testSession.itemExists(pPath));
    assertTrue(testSession.propertyExists(pPath));
    Property p=testSession.getProperty(pPath);
    assertEquals(pPath,p.getPath());
  }
}
