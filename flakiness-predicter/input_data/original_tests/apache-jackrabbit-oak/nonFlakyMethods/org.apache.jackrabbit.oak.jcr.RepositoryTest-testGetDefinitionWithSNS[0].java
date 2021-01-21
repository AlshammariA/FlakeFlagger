@Test public void testGetDefinitionWithSNS() throws RepositoryException, IOException {
  Session session=getAdminSession();
  Node node=session.getNode("/jcr:system/jcr:nodeTypes/nt:file");
  for (  Node child : getChildNodes(node,"jcr:childNodeDefinition")) {
    NodeDefinition definition=child.getDefinition();
    definition.getDefaultPrimaryType();
    definition.getRequiredPrimaryTypes();
  }
}
