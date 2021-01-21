@Test public void autoCreatedItems() throws Exception {
  Session s=getAdminSession();
  new TestContentLoader().loadTestContent(s);
  Node test=s.getRootNode().addNode("test","test:autoCreate");
  assertTrue(test.hasProperty("test:property"));
  assertEquals("default value",test.getProperty("test:property").getString());
  assertTrue(test.hasProperty("test:propertyMulti"));
  assertArrayEquals(new Value[]{s.getValueFactory().createValue("value1"),s.getValueFactory().createValue("value2")},test.getProperty("test:propertyMulti").getValues());
  assertTrue(test.hasNode("test:folder"));
  Node folder=test.getNode("test:folder");
  assertEquals("nt:folder",folder.getPrimaryNodeType().getName());
  assertTrue(folder.hasProperty("jcr:created"));
  assertTrue(folder.hasProperty("jcr:createdBy"));
}
