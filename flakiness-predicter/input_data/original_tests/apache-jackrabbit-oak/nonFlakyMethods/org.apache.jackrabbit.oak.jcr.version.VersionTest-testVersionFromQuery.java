public void testVersionFromQuery() throws RepositoryException, NotExecutableException {
  Node n=testRootNode.addNode(nodeName1,testNodeType);
  n.addMixin(mixVersionable);
  superuser.save();
  VersionManager vMgr=superuser.getWorkspace().getVersionManager();
  vMgr.checkpoint(n.getPath());
  QueryManager qm=superuser.getWorkspace().getQueryManager();
  Version v=vMgr.getBaseVersion(n.getPath());
  Query q=qm.createQuery("//element(*, nt:version)[@jcr:uuid = '" + v.getIdentifier() + "']",Query.XPATH);
  NodeIterator nodes=q.execute().getNodes();
  assertTrue(nodes.hasNext());
  assertTrue(nodes.nextNode() instanceof Version);
  RowIterator rows=q.execute().getRows();
  assertTrue(rows.hasNext());
  assertTrue(rows.nextRow().getNode() instanceof Version);
}
