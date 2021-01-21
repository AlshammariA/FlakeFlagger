public void testQuery4() throws Exception {
  String statement="/jcr:root/myRep:security/myRep:authorizables//" + "element(*,myRep:Authorizable)[@my:property='value']";
  QueryManager qm=session.getWorkspace().getQueryManager();
  Query q=qm.createQuery(statement,"xpath");
  q.getBindVariableNames();
  QueryResult qr=q.execute();
  NodeIterator ni=qr.getNodes();
  while (ni.hasNext()) {
    ni.next();
  }
}
