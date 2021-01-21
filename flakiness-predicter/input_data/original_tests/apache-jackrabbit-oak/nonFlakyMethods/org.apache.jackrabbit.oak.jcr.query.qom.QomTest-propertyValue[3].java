@Test public void propertyValue() throws RepositoryException {
  PropertyValue pv=f.propertyValue("selectorName","propertyName");
  assertEquals("selectorName",pv.getSelectorName());
  assertEquals("propertyName",pv.getPropertyName());
  assertEquals("[selectorName].[propertyName]",pv.toString());
  assertEquals("*",f.propertyValue(null,null).toString());
  assertEquals("[s].*",f.propertyValue("s",null).toString());
  assertEquals("[p]",f.propertyValue(null,"p").toString());
  assertEquals("[s].[p]",f.propertyValue("s","p").toString());
}
