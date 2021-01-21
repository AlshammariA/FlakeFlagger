@Test public void isProperlyConfiguredSingleValuePropertyNames(){
  NodeBuilder definition=createNiceMock(NodeBuilder.class);
  PropertyState names=createNiceMock(PropertyState.class);
  expect(names.count()).andReturn(1);
  expect(names.getValue(Type.NAME,0)).andReturn("jcr:lastModified").anyTimes();
  expect(definition.getProperty(IndexConstants.PROPERTY_NAMES)).andReturn(names).anyTimes();
  replay(names);
  replay(definition);
  OrderedPropertyIndexEditor ie=new OrderedPropertyIndexEditor(definition,null,null);
  assertNotNull("With a correct property set 'propertyNames' can't be null",ie.getPropertyNames());
  assertEquals(1,ie.getPropertyNames().size());
  assertEquals("jcr:lastModified",ie.getPropertyNames().iterator().next());
  assertTrue("Expecting a properly configured index",ie.isProperlyConfigured());
}
