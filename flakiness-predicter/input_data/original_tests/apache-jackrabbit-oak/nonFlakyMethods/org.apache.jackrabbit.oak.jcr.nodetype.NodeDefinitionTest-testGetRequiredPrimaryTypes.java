@Test public void testGetRequiredPrimaryTypes() throws RepositoryException {
  for (  String path : paths) {
    Node n=superuser.getNode(path);
    NodeDefinition def=n.getDefinition();
    def.getRequiredPrimaryTypes();
  }
}
