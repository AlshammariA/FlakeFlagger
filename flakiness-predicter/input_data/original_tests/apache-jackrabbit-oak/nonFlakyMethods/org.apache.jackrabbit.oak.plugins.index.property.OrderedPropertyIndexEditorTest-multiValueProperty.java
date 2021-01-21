@Test public void multiValueProperty(){
  NodeBuilder definition=createNiceMock(NodeBuilder.class);
  PropertyState names=createNiceMock(PropertyState.class);
  expect(names.isArray()).andReturn(true).anyTimes();
  expect(names.count()).andReturn(2).anyTimes();
  expect(names.getValue(Type.NAME,0)).andReturn("jcr:lastModified").anyTimes();
  expect(names.getValue(Type.NAME,1)).andReturn("foo:bar").anyTimes();
  expect(names.getValue(Type.NAMES)).andReturn(Arrays.asList("jcr:lastModified","foo:bar")).anyTimes();
  expect(definition.getProperty(IndexConstants.PROPERTY_NAMES)).andReturn(names).anyTimes();
  replay(names);
  replay(definition);
  OrderedPropertyIndexEditor ie=new OrderedPropertyIndexEditor(definition,null,null);
  assertNotNull("With a correct property set 'propertyNames' can't be null",ie.getPropertyNames());
  assertEquals("When multiple properties are a passed only the first one is taken",1,ie.getPropertyNames().size());
  assertEquals("jcr:lastModified",ie.getPropertyNames().iterator().next());
  assertTrue("Expecting a properly configured index",ie.isProperlyConfigured());
}
