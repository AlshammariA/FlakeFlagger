@Test public void testGetParent() throws Exception {
  deny(path,privilegesFromName(PrivilegeConstants.REP_READ_NODES));
  List<String> propertyPaths=new ArrayList<String>();
  propertyPaths.add(childPPath);
  propertyPaths.add(childchildPPath);
  propertyPaths.add(path + "/jcr:primaryType");
  for (  String pPath : propertyPaths) {
    Property p=testSession.getProperty(pPath);
    try {
      Node n=p.getParent();
      fail();
    }
 catch (    AccessDeniedException e) {
    }
  }
}
