@Test public void column() throws RepositoryException {
  Column c=f.column("selectorName","propertyName","columnName");
  assertEquals("selectorName",c.getSelectorName());
  assertEquals("propertyName",c.getPropertyName());
  assertEquals("columnName",c.getColumnName());
  assertEquals("[selectorName].[propertyName] AS [columnName]",c.toString());
  assertEquals("[p]",f.column(null,"p",null).toString());
  assertEquals("[p] AS [c]",f.column(null,"p","c").toString());
  assertEquals("[s].[p]",f.column("s","p",null).toString());
  assertEquals("[s].[p] AS [c]",f.column("s","p","c").toString());
  assertEquals("[s].* AS [c]",f.column("s",null,"c").toString());
  assertEquals("* AS [c]",f.column(null,null,"c").toString());
  assertEquals("*",f.column(null,null,null).toString());
  assertEquals("[s].*",f.column("s",null,null).toString());
}
