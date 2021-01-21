@Test public void importNodeType() throws RepositoryException, IOException, ParseException {
  Session session=getAdminSession();
  NodeTypeManager manager=session.getWorkspace().getNodeTypeManager();
  if (!manager.hasNodeType("myNodeType")) {
    StringBuilder defs=new StringBuilder();
    defs.append("[\"myNodeType\"]\n");
    defs.append("  - prop1\n");
    defs.append("  + * (nt:base) = nt:unstructured \n");
    Reader cndReader=new InputStreamReader(new ByteArrayInputStream(defs.toString().getBytes()));
    CndImporter.registerNodeTypes(cndReader,session);
  }
  NodeType myNodeType=manager.getNodeType("myNodeType");
  assertTrue(myNodeType.isNodeType("nt:base"));
}
