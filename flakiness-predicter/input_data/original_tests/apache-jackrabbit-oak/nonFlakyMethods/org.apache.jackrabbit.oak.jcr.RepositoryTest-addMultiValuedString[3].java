@Test public void addMultiValuedString() throws RepositoryException {
  Node parentNode=getNode(TEST_PATH);
  Value[] values=new Value[2];
  values[0]=getAdminSession().getValueFactory().createValue("one");
  values[1]=getAdminSession().getValueFactory().createValue("two");
  parentNode.setProperty("multi string",values);
  parentNode.getSession().save();
  Session session2=createAdminSession();
  try {
    Property property=session2.getProperty(TEST_PATH + "/multi string");
    assertTrue(property.isMultiple());
    assertEquals(PropertyType.STRING,property.getType());
    Value[] values2=property.getValues();
    assertEquals(values.length,values2.length);
    assertEquals(values[0],values2[0]);
    assertEquals(values[1],values2[1]);
  }
  finally {
    session2.logout();
  }
}
