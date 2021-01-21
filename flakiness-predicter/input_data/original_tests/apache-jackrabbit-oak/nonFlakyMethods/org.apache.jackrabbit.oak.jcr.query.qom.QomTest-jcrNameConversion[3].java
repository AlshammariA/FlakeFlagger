@Test public void jcrNameConversion() throws RepositoryException {
  assertEquals("[nt:base]",f.column(null,NodeType.NT_BASE,null).toString());
  assertEquals("[s1].[nt:base] = [s2].[nt:base]",f.equiJoinCondition("s1",NodeType.NT_BASE,"s2",NodeType.NT_BASE).toString());
  assertEquals("CONTAINS([nt:base], null)",f.fullTextSearch(null,NodeType.NT_BASE,null).toString());
  assertEquals("CAST('nt:base' AS NAME)",f.literal(vf.createValue(NodeType.NT_BASE,PropertyType.NAME)).toString());
  assertEquals("[nt:base] IS NOT NULL",f.propertyExistence(null,NodeType.NT_BASE).toString());
  assertEquals("[nt:base]",f.propertyValue(null,NodeType.NT_BASE).toString());
  assertEquals("[nt:base]",f.selector(NodeType.NT_BASE,null).toString());
  Source source1=f.selector(NodeType.NT_BASE,"selector");
  Column[] columns=new Column[]{f.column("selector",null,null)};
  Constraint constraint2=f.childNode("selector","/");
  QueryObjectModel qom=f.createQuery(source1,constraint2,null,columns);
  assertEquals("select [selector].* from " + "[nt:base] AS [selector] " + "where ISCHILDNODE([selector], [/])",qom.toString());
}
