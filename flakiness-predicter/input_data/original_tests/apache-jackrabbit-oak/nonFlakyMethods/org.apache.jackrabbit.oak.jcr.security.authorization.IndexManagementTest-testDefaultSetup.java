public void testDefaultSetup() throws RepositoryException {
  assertFalse(testSession.hasPermission(path,Permissions.getString(Permissions.INDEX_DEFINITION_MANAGEMENT)));
}
