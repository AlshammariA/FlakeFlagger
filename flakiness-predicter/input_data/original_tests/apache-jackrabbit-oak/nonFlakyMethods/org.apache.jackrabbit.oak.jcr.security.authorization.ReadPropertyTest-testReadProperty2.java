@Test public void testReadProperty2() throws Exception {
  deny(path,privilegesFromName(PrivilegeConstants.REP_READ_NODES));
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
  }
}
