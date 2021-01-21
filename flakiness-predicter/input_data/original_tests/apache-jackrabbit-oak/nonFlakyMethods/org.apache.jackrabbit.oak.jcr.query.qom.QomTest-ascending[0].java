@Test public void ascending() throws RepositoryException {
  PropertyValue p=f.propertyValue("selectorName","propertyName");
  Ordering o=f.ascending(p);
  assertEquals(p,o.getOperand());
  assertEquals(QueryObjectModelConstants.JCR_ORDER_ASCENDING,o.getOrder());
  assertEquals("[selectorName].[propertyName]",p.toString());
}
