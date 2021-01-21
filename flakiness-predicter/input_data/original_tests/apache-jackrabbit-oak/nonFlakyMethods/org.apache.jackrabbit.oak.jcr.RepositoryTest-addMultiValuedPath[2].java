@Test public void addMultiValuedPath() throws RepositoryException {
  Node parentNode=getNode(TEST_PATH);
  Value[] values=new Value[2];
  values[0]=getAdminSession().getValueFactory().createValue("/nt:foo/jcr:bar",PropertyType.PATH);
  values[1]=getAdminSession().getValueFactory().createValue("/",PropertyType.PATH);
  parentNode.setProperty("multi path",values);
  parentNode.getSession().save();
  Session session2=createAnonymousSession();
  try {
    Property property=session2.getProperty(TEST_PATH + "/multi path");
    assertTrue(property.isMultiple());
    assertEquals(PropertyType.PATH,property.getType());
    Value[] values2=property.getValues();
    assertEquals(values.length,values2.length);
    assertEquals(values[0],values2[0]);
    assertEquals(values[1],values2[1]);
  }
  finally {
    session2.logout();
  }
}
