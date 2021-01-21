@Test public void testGetRegisteredPrivileges() throws RepositoryException {
  Privilege[] registered=privilegeManager.getRegisteredPrivileges();
  Set<Privilege> set=new HashSet<Privilege>();
  Privilege all=privilegeManager.getPrivilege(Privilege.JCR_ALL);
  set.add(all);
  set.addAll(Arrays.asList(all.getAggregatePrivileges()));
  for (  Privilege p : registered) {
    assertTrue(p.getName(),set.remove(p));
  }
  assertTrue(set.isEmpty());
}
