@Test public void testSetPropertyByRelPath() throws NotExecutableException, RepositoryException {
  Value[] v=new Value[]{superuser.getValueFactory().createValue("Super User")};
  List<String> relPaths=new ArrayList<String>();
  relPaths.add("testing/Fullname");
  relPaths.add("testing/Email");
  relPaths.add("testing/testing/testing/Fullname");
  relPaths.add("testing/testing/testing/Email");
  for (  String relPath : relPaths) {
    try {
      user.setProperty(relPath,v);
      superuser.save();
      assertTrue(user.hasProperty(relPath));
      String propName=Text.getName(relPath);
      assertFalse(user.hasProperty(propName));
    }
  finally {
      user.removeProperty(relPath);
      superuser.save();
    }
  }
}
