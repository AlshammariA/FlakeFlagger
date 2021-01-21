@Test public void testModifyNodeTypeWithPrivilege() throws Exception {
  modify(null,JCR_NODE_TYPE_DEFINITION_MANAGEMENT.toString(),true);
  assertHasRepoPrivilege(JCR_NODE_TYPE_DEFINITION_MANAGEMENT,true);
  modify(null,JCR_NODE_TYPE_DEFINITION_MANAGEMENT.toString(),false);
  assertHasRepoPrivilege(JCR_NODE_TYPE_DEFINITION_MANAGEMENT,false);
}
