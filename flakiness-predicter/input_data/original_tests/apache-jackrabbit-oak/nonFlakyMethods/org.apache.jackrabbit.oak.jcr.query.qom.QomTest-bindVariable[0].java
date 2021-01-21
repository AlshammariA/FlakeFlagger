@Test public void bindVariable() throws RepositoryException {
  BindVariableValue b=f.bindVariable("bindVariableName");
  assertEquals("bindVariableName",b.getBindVariableName());
  assertEquals("$bindVariableName",b.toString());
}
