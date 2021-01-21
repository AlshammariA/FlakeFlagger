@Test public void not() throws RepositoryException {
  Constraint c=f.propertyExistence("x","c0");
  Not n=f.not(c);
  assertEquals(c,n.getConstraint());
  assertEquals("[x].[c0] IS NOT NULL",c.toString());
  assertEquals("* IS NOT NULL",f.propertyExistence(null,null).toString());
  assertEquals("[s].* IS NOT NULL",f.propertyExistence("s",null).toString());
  assertEquals("[p] IS NOT NULL",f.propertyExistence(null,"p").toString());
  assertEquals("[s].[p] IS NOT NULL",f.propertyExistence("s","p").toString());
}
