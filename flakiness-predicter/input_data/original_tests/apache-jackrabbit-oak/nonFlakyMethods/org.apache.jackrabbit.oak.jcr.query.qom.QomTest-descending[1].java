@Test public void descending() throws RepositoryException {
  PropertyValue p=f.propertyValue("selectorName","propertyName");
  Ordering o=f.descending(p);
  assertEquals(p,o.getOperand());
  assertEquals(QueryObjectModelConstants.JCR_ORDER_DESCENDING,o.getOrder());
  assertEquals("[selectorName].[propertyName] DESC",o.toString());
}
