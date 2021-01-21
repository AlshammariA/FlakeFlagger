@Test public void testUserIndexDefinitions() throws Exception {
  Tree oakIndex=root.getTree('/' + IndexConstants.INDEX_DEFINITIONS_NAME);
  assertTrue(oakIndex.exists());
  Tree id=oakIndex.getChild("authorizableId");
  assertIndexDefinition(id,UserConstants.REP_AUTHORIZABLE_ID,true);
  Tree princName=oakIndex.getChild("principalName");
  assertIndexDefinition(princName,UserConstants.REP_PRINCIPAL_NAME,true);
  Iterable<String> declaringNtNames=TreeUtil.getStrings(princName,IndexConstants.DECLARING_NODE_TYPES);
  assertArrayEquals(new String[]{UserConstants.NT_REP_AUTHORIZABLE},Iterables.toArray(declaringNtNames,String.class));
}
