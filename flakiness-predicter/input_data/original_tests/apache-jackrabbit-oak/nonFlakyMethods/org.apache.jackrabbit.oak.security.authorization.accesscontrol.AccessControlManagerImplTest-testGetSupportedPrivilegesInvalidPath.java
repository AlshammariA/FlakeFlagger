@Test public void testGetSupportedPrivilegesInvalidPath() throws Exception {
  for (  String path : getInvalidPaths()) {
    try {
      acMgr.getSupportedPrivileges(path);
      fail("Expects valid node path, found: " + path);
    }
 catch (    RepositoryException e) {
    }
  }
}
