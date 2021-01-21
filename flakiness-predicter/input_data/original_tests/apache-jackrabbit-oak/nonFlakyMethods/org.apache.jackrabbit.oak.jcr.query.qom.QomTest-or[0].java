@Test public void or() throws RepositoryException {
  Constraint c0=f.propertyExistence("x","c0");
  Constraint c1=f.propertyExistence("x","c1");
  Or or=f.or(c0,c1);
  assertEquals(or.getConstraint1(),c0);
  assertEquals(or.getConstraint2(),c1);
  assertEquals("([x].[c0] IS NOT NULL) OR ([x].[c1] IS NOT NULL)",or.toString());
}
