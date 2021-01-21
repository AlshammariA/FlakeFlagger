@Test public void testModifyNamespaceWithPrivilege() throws Exception {
  modify(null,PrivilegeConstants.JCR_NAMESPACE_MANAGEMENT.toString(),true);
  assertHasRepoPrivilege(PrivilegeConstants.JCR_NAMESPACE_MANAGEMENT,true);
  modify(null,PrivilegeConstants.JCR_NAMESPACE_MANAGEMENT.toString(),false);
  assertHasRepoPrivilege(PrivilegeConstants.JCR_NAMESPACE_MANAGEMENT,false);
}
