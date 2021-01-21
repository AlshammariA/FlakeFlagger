@Test public void testOak1354() throws Exception {
  Session session=createAdminSession();
  NodeTypeManager manager=session.getWorkspace().getNodeTypeManager();
  if (!manager.hasNodeType("mymixinOak1354")) {
    StringBuilder defs=new StringBuilder();
    defs.append("[mymixinOak1354]\n");
    defs.append("  mixin");
    Reader cndReader=new InputStreamReader(new ByteArrayInputStream(defs.toString().getBytes()));
    CndImporter.registerNodeTypes(cndReader,session);
  }
  Node p=session.getRootNode().addNode("one");
  p.addMixin("mymixinOak1354");
  session.save();
  Query q=session.getWorkspace().getQueryManager().createQuery("SELECT * FROM [mymixinOak1354]",Query.JCR_SQL2);
  QueryResult qr=q.execute();
  NodeIterator ni=qr.getNodes();
  assertTrue(ni.hasNext());
  Node n=ni.nextNode();
  assertEquals("/one",n.getPath());
  assertFalse(ni.hasNext());
}
