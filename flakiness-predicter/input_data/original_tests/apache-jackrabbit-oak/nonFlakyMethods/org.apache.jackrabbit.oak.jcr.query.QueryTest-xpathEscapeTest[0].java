@SuppressWarnings("deprecation") @Test public void xpathEscapeTest() throws RepositoryException {
  Session writer=createAdminSession();
  Session reader=createAdminSession();
  try {
    Node rootNode=writer.getRootNode();
    Node node=rootNode.addNode("test","nt:unstructured");
    node.addNode(".tokens");
    writer.save();
    QueryManager qm=reader.getWorkspace().getQueryManager();
    Query q=qm.createQuery("/jcr:root//*[_x002e_tokens/@jcr:primaryType]",Query.XPATH);
    NodeIterator res=q.execute().getNodes();
    assertEquals(1,res.getSize());
  }
  finally {
    if (reader != null) {
      reader.logout();
    }
    if (writer != null) {
      writer.logout();
    }
  }
}
