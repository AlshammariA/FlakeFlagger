@Test public void comparison() throws RepositoryException {
  PropertyValue p=f.propertyValue("selectorName","propertyName");
  Literal l=f.literal(vf.createValue(1));
  Comparison c=f.comparison(p,QueryObjectModelConstants.JCR_OPERATOR_EQUAL_TO,l);
  assertEquals(p,c.getOperand1());
  assertEquals(QueryObjectModelConstants.JCR_OPERATOR_EQUAL_TO,c.getOperator());
  assertEquals(l,c.getOperand2());
  assertEquals("[selectorName].[propertyName] = 1",c.toString());
}
