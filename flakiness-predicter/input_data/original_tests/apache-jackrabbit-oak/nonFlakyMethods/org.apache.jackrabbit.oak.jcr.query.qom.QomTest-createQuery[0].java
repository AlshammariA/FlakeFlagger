@Test public void createQuery() throws RepositoryException {
  Selector s=f.selector("nt:file","x");
  BindVariableValue b=f.bindVariable("var");
  Constraint c=f.propertyExistence("x","c");
  PropertyValue p=f.propertyValue("x","propertyName");
  c=f.and(f.comparison(p,QueryObjectModelConstants.JCR_OPERATOR_EQUAL_TO,b),c);
  Ordering o=f.ascending(p);
  Column col=f.column("x","propertyName","columnName");
  Ordering[] ords=new Ordering[]{o};
  Column[] cols=new Column[]{col};
  QueryObjectModel q=f.createQuery(s,c,ords,cols);
  assertEquals(Query.JCR_JQOM,q.getLanguage());
  String[] bv=q.getBindVariableNames();
  assertEquals(1,bv.length);
  assertEquals("var",bv[0]);
  assertEquals(s,q.getSource());
  assertEquals(c,q.getConstraint());
  assertEquals(o,q.getOrderings()[0]);
  assertEquals(col,q.getColumns()[0]);
}
