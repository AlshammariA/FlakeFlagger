@Test public void testGetRequiredPrimaryTypes2() throws RepositoryException {
  for (  String path : paths) {
    Node n=superuser.getNode(path);
    for (    NodeDefinition nd : getAggregatedNodeDefinitions(n)) {
      nd.getRequiredPrimaryTypes();
    }
  }
}
