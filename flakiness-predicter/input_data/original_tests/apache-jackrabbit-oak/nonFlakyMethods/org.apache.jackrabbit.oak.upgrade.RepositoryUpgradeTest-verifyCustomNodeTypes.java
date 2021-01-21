@Test public void verifyCustomNodeTypes() throws Exception {
  Session session=createAdminSession();
  try {
    NodeTypeManager manager=session.getWorkspace().getNodeTypeManager();
    assertTrue(manager.hasNodeType("test:unstructured"));
    NodeType type=manager.getNodeType("test:unstructured");
    assertFalse(type.isMixin());
    assertTrue(type.isNodeType("nt:unstructured"));
    boolean foundDefaultString=false;
    boolean foundDefaultPath=false;
    for (    PropertyDefinition pDef : type.getPropertyDefinitions()) {
      if ("defaultString".equals(pDef.getName())) {
        assertEquals(PropertyType.STRING,pDef.getRequiredType());
        assertNotNull(pDef.getDefaultValues());
        assertEquals(1,pDef.getDefaultValues().length);
        assertEquals("stringValue",pDef.getDefaultValues()[0].getString());
        foundDefaultString=true;
      }
 else       if ("defaultPath".equals(pDef.getName())) {
        assertEquals(PropertyType.PATH,pDef.getRequiredType());
        assertNotNull(pDef.getDefaultValues());
        assertEquals(1,pDef.getDefaultValues().length);
        assertEquals("/jcr:path/nt:value",pDef.getDefaultValues()[0].getString());
        foundDefaultPath=true;
      }
    }
    assertTrue("Expected property definition with name \"defaultString\"",foundDefaultString);
    assertTrue("Expected property definition with name \"defaultPath\"",foundDefaultPath);
  }
  finally {
    session.logout();
  }
}
