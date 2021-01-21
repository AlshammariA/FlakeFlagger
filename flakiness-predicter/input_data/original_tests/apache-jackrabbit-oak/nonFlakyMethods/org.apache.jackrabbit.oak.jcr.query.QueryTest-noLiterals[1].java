@Test public void noLiterals() throws RepositoryException {
  Session session=getAdminSession();
  ValueFactory vf=session.getValueFactory();
  QueryManager qm=session.getWorkspace().getQueryManager();
  try {
    Query q=qm.createQuery("select text from [nt:base] where password = 'x'",Query.JCR_SQL2 + "-noLiterals");
    q.execute();
    fail();
  }
 catch (  InvalidQueryException e) {
    assertTrue(e.toString(),e.toString().indexOf("literals of this type not allowed") > 0);
  }
  Query q=qm.createQuery("select text from [nt:base] where password = $p",Query.JCR_SQL2 + "-noLiterals");
  q.bindValue("p",vf.createValue("x"));
  q.execute();
}
