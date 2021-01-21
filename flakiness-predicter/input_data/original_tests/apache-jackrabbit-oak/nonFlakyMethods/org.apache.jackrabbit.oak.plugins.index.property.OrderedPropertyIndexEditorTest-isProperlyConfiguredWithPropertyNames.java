@Test public void isProperlyConfiguredWithPropertyNames(){
  NodeBuilder definition=createNiceMock(NodeBuilder.class);
  PropertyState names=createNiceMock(PropertyState.class);
  expect(names.count()).andReturn(1);
  expect(definition.getProperty(IndexConstants.PROPERTY_NAMES)).andReturn(names).anyTimes();
  replay(names);
  replay(definition);
  OrderedPropertyIndexEditor ie=new OrderedPropertyIndexEditor(definition,null,null);
  assertFalse("With empty or missing property the index should not work.",ie.isProperlyConfigured());
}
