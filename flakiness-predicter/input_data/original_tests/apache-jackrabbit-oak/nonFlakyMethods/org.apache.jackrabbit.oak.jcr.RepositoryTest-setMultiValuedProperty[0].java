@Test public void setMultiValuedProperty() throws RepositoryException {
  Node parentNode=getNode(TEST_PATH);
  Value[] values=new Value[2];
  values[0]=getAdminSession().getValueFactory().createValue("one");
  values[1]=getAdminSession().getValueFactory().createValue("two");
  parentNode.setProperty("multi string2",values);
  parentNode.getSession().save();
  values[0]=getAdminSession().getValueFactory().createValue("eins");
  values[1]=getAdminSession().getValueFactory().createValue("zwei");
  parentNode.setProperty("multi string2",values);
  parentNode.getSession().save();
  Session session2=createAnonymousSession();
  try {
    Property property=session2.getProperty(TEST_PATH + "/multi string2");
    assertTrue(property.isMultiple());
    Value[] values2=property.getValues();
    assertEquals(2,values.length);
    assertEquals(values[0],values2[0]);
    assertEquals(values[1],values2[1]);
  }
  finally {
    session2.logout();
  }
}
