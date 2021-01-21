@Test public void addMultiValuedDate() throws RepositoryException {
  Node parentNode=getNode(TEST_PATH);
  Value[] values=new Value[2];
  Calendar calendar=Calendar.getInstance();
  values[0]=getAdminSession().getValueFactory().createValue(calendar);
  calendar.add(Calendar.DAY_OF_MONTH,1);
  values[1]=getAdminSession().getValueFactory().createValue(calendar);
  parentNode.setProperty("multi date",values);
  parentNode.getSession().save();
  Session session2=createAnonymousSession();
  try {
    Property property=session2.getProperty(TEST_PATH + "/multi date");
    assertTrue(property.isMultiple());
    assertEquals(PropertyType.DATE,property.getType());
    Value[] values2=property.getValues();
    assertEquals(values.length,values2.length);
    assertEquals(values[0],values2[0]);
    assertEquals(values[1],values2[1]);
  }
  finally {
    session2.logout();
  }
}
