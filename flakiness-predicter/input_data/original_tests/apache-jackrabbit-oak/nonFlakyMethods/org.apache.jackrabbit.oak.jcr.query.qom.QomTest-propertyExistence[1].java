@Test public void propertyExistence() throws RepositoryException {
  PropertyExistence pe=f.propertyExistence("selectorName","propertyName");
  assertEquals("selectorName",pe.getSelectorName());
  assertEquals("propertyName",pe.getPropertyName());
  assertEquals("[selectorName].[propertyName] IS NOT NULL",pe.toString());
  assertEquals("* IS NOT NULL",f.propertyExistence(null,null).toString());
  assertEquals("[s].* IS NOT NULL",f.propertyExistence("s",null).toString());
  assertEquals("[p] IS NOT NULL",f.propertyExistence(null,"p").toString());
  assertEquals("[s].[p] IS NOT NULL",f.propertyExistence("s","p").toString());
}
