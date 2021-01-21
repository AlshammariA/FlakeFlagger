@Test public void testOak1096() throws RepositoryException {
  Session writer=createAdminSession();
  Session reader=createAdminSession();
  try {
    Node rootNode=writer.getRootNode();
    Node node=rootNode.addNode("test","nt:unstructured");
    node.setProperty("text","find me");
    writer.save();
    QueryManager qm=reader.getWorkspace().getQueryManager();
    Query q=qm.createQuery("select * from 'nt:base' where contains(*, 'find me')",Query.JCR_SQL2);
    NodeIterator res=q.execute().getNodes();
    assertEquals("False amount of hits",1,res.getSize());
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
