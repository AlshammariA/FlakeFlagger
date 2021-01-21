@Test public void testGetPrivilege() throws RepositoryException {
  Set<String> aggregatedPrivilegeNames=ImmutableSet.of("jcr:read","jcr:modifyProperties","jcr:write","rep:write","jcr:all");
  for (  Privilege priv : privilegeManager.getRegisteredPrivileges()) {
    String privName=priv.getName();
    boolean isAggregate=aggregatedPrivilegeNames.contains(privName);
    assertPrivilege(priv,privName,isAggregate,false);
  }
}
