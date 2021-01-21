public void testJoin() throws Exception {
  Node n=superuser.getNode(path);
  Node visible=n.addNode(nodeName1,testNodeType);
  allow(visible.getPath(),privilegesFromName(Privilege.JCR_READ));
  Node invisible=visible.addNode(nodeName2,testNodeType);
  Node invisible2=invisible.addNode(nodeName3,testNodeType);
  deny(invisible.getPath(),privilegesFromName(Privilege.JCR_READ));
  deny(invisible2.getPath(),privilegesFromName(Privilege.JCR_READ));
  superuser.save();
  testSession.refresh(false);
  testSession.checkPermission(visible.getPath(),Session.ACTION_READ);
  try {
    testSession.checkPermission(invisible.getPath(),Session.ACTION_READ);
    fail();
  }
 catch (  AccessControlException e) {
  }
  Node x=testSession.getNode(visible.getPath());
  ValueFactory vf=testSession.getValueFactory();
  Query q;
  QueryResult r;
  NodeIterator ni;
  q=testSession.getWorkspace().getQueryManager().createQuery("select * from [nt:base] where [jcr:path]=$path",Query.JCR_SQL2);
  q.bindValue("path",vf.createValue(visible.getPath()));
  r=q.execute();
  ni=r.getNodes();
  assertTrue(ni.hasNext());
  x=ni.nextNode();
  assertTrue(x.getSession() == testSession);
  q=testSession.getWorkspace().getQueryManager().createQuery("select * from [nt:base] where [jcr:path]=$path",Query.JCR_SQL2);
  q.bindValue("path",vf.createValue(invisible.getPath()));
  r=q.execute();
  assertFalse(r.getNodes().hasNext());
  q=superuser.getWorkspace().getQueryManager().createQuery("select a.* from [nt:base] as a " + "inner join [nt:base] as b on isdescendantnode(b, a) " + "where a.[jcr:path]=$path",Query.JCR_SQL2);
  q.bindValue("path",vf.createValue(visible.getPath()));
  r=q.execute();
  assertTrue(r.getNodes().hasNext());
  q=testSession.getWorkspace().getQueryManager().createQuery("select a.* from [nt:base] as a " + "inner join [nt:base] as b on isdescendantnode(b, a) " + "where a.[jcr:path]=$path",Query.JCR_SQL2);
  q.bindValue("path",vf.createValue(visible.getPath()));
  r=q.execute();
  assertFalse(r.getNodes().hasNext());
}
