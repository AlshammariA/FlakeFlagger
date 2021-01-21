@Test public void testWriteDefinition() throws Exception {
  PrivilegeDefinitionWriter writer=new PrivilegeDefinitionWriter(root);
  writer.writeDefinition(new ImmutablePrivilegeDefinition("tmp",true,asList(JCR_READ_ACCESS_CONTROL,JCR_MODIFY_ACCESS_CONTROL)));
  Tree privRoot=root.getTree(PRIVILEGES_PATH);
  assertTrue(privRoot.hasChild("tmp"));
  Tree tmpTree=privRoot.getChild("tmp");
  assertTrue(TreeUtil.getBoolean(tmpTree,REP_IS_ABSTRACT));
  assertArrayEquals(new String[]{JCR_READ_ACCESS_CONTROL,JCR_MODIFY_ACCESS_CONTROL},Iterables.toArray(TreeUtil.getStrings(tmpTree,REP_AGGREGATES),String.class));
}
