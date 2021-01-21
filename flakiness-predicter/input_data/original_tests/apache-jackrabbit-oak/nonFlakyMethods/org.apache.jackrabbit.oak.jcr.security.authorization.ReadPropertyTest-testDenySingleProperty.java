@Test public void testDenySingleProperty() throws Exception {
  allow(path,privilegesFromName(PrivilegeConstants.JCR_READ));
  deny(path,privilegesFromName(PrivilegeConstants.REP_READ_PROPERTIES),createGlobRestriction("*/" + propertyName1));
  assertTrue(testSession.nodeExists(path));
  assertTrue(testSession.itemExists(path));
  assertTrue(testSession.nodeExists(childNPath));
  List<String> allowed=new ArrayList<String>();
  allowed.add(path + "/jcr:primaryType");
  allowed.add(childNPath + "/jcr:primaryType");
  for (  String pPath : allowed) {
    assertTrue(testSession.itemExists(pPath));
    assertTrue(testSession.propertyExists(pPath));
  }
  List<String> denied=new ArrayList<String>();
  denied.add(childPPath);
  denied.add(childchildPPath);
  for (  String pPath : denied) {
    assertFalse(testSession.itemExists(pPath));
    assertFalse(testSession.propertyExists(pPath));
  }
  Node target=testSession.getNode(path);
  PropertyIterator pit=target.getProperties();
  while (pit.hasNext()) {
    assertFalse(propertyName1.equals(pit.nextProperty().getName()));
  }
}
