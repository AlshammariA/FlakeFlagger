@Test public void and() throws RepositoryException {
  Constraint c0=f.propertyExistence("x","c0");
  Constraint c1=f.propertyExistence("x","c1");
  And and=f.and(c0,c1);
  assertEquals(and.getConstraint1(),c0);
  assertEquals(and.getConstraint2(),c1);
  assertEquals("([x].[c0] IS NOT NULL) AND ([x].[c1] IS NOT NULL)",and.toString());
}
