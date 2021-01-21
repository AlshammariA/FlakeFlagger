@Test public void orderBy() throws Exception {
  Session session=getAdminSession();
  Node root=session.getRootNode();
  Node index=root.getNode("oak:index").addNode("lastMod","oak:QueryIndexDefinition");
  index.setProperty("reindex",true);
  index.setProperty("type","ordered");
  index.setProperty("propertyNames",new String[]{"lastMod"},PropertyType.NAME);
  Node nodeTypeIndex=root.getNode("oak:index").getNode("nodetype");
  nodeTypeIndex.setProperty("declaringNodeTypes",new String[]{},PropertyType.NAME);
  Node test=root.addNode("test");
  for (int i=0; i < 10; i++) {
    Node n=test.addNode("test" + i,"oak:Unstructured");
    Calendar cal=Calendar.getInstance();
    cal.setTimeInMillis(Timestamp.valueOf("2000-01-01 10:00:00").getTime() + 1000 * i);
    n.addNode("content").setProperty("lastMod",cal);
  }
  session.save();
  String query="/jcr:root/test//*[@jcr:primaryType='oak:Unstructured'] " + "order by content/@lastMod descending";
  QueryResult r=session.getWorkspace().getQueryManager().createQuery(query,"xpath").execute();
  NodeIterator it=r.getNodes();
  StringBuilder buff=new StringBuilder();
  while (it.hasNext()) {
    if (buff.length() > 0) {
      buff.append(", ");
    }
    buff.append(it.nextNode().getPath());
  }
  assertEquals("/test/test9, /test/test8, /test/test7, /test/test6, /test/test5, /test/test4, /test/test3, /test/test2, /test/test1, /test/test0",buff.toString());
  RowIterator rit;
  r=session.getWorkspace().getQueryManager().createQuery("explain " + query,"xpath").execute();
  rit=r.getRows();
  assertEquals("[nt:base] as [a] /* ordered order by lastMod ancestor 1 " + "where ([a].[jcr:primaryType] = cast('oak:Unstructured' as string)) " + "and (isdescendantnode([a], [/test])) */",rit.nextRow().getValue("plan").getString());
  query="/jcr:root/test//*[@jcr:primaryType='oak:Unstructured' " + "and  content/@lastMod > '2001-02-01']";
  r=session.getWorkspace().getQueryManager().createQuery("explain " + query,"xpath").execute();
  rit=r.getRows();
  assertEquals("[nt:base] as [a] /* ordered lastMod > 2001-02-01 " + "where (([a].[jcr:primaryType] = cast('oak:Unstructured' as string)) " + "and ([a].[content/lastMod] > cast('2001-02-01' as string))) "+ "and (isdescendantnode([a], [/test])) */",rit.nextRow().getValue("plan").getString());
}
