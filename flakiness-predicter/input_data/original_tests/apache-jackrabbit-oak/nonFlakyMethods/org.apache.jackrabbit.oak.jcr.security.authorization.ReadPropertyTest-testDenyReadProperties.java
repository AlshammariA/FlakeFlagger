@Test public void testDenyReadProperties() throws Exception {
  allow(path,privilegesFromName(PrivilegeConstants.JCR_READ));
  deny(path,privilegesFromName(PrivilegeConstants.REP_READ_PROPERTIES));
  assertTrue(testSession.nodeExists(path));
  assertTrue(testSession.itemExists(path));
  assertTrue(testSession.nodeExists(childNPath));
  List<String> propertyPaths=new ArrayList<String>();
  propertyPaths.add(childPPath);
  propertyPaths.add(childchildPPath);
  propertyPaths.add(path + "/jcr:primaryType");
  for (  String pPath : propertyPaths) {
    assertFalse(testSession.itemExists(pPath));
    assertFalse(testSession.propertyExists(pPath));
  }
  Node target=testSession.getNode(path);
  assertFalse(target.getProperties().hasNext());
}
