@Test public void testHashCode() throws RepositoryException {
  JackrabbitAccessControlEntry ace=createEntry(PrivilegeConstants.JCR_ALL);
  Privilege[] declaredAllPrivs=acMgr.privilegeFromName(PrivilegeConstants.JCR_ALL).getDeclaredAggregatePrivileges();
  Privilege[] aggregateAllPrivs=acMgr.privilegeFromName(PrivilegeConstants.JCR_ALL).getAggregatePrivileges();
  List<Privilege> l=Lists.newArrayList(aggregateAllPrivs);
  l.add(l.remove(0));
  Privilege[] reordered=l.toArray(new Privilege[l.size()]);
  Map<AccessControlEntry,AccessControlEntry> equivalent=new HashMap<AccessControlEntry,AccessControlEntry>();
  equivalent.put(ace,createEntry(PrivilegeConstants.JCR_ALL));
  equivalent.put(ace,createEntry(PrivilegeConstants.JCR_ALL,PrivilegeConstants.JCR_ALL));
  equivalent.put(ace,createEntry(testPrincipal,declaredAllPrivs,true));
  equivalent.put(ace,createEntry(testPrincipal,aggregateAllPrivs,true));
  equivalent.put(ace,createEntry(testPrincipal,reordered,true));
  equivalent.put(createEntry(testPrincipal,declaredAllPrivs,true),createEntry(testPrincipal,reordered,true));
  equivalent.put(createEntry(testPrincipal,declaredAllPrivs,true),createEntry(testPrincipal,aggregateAllPrivs,true));
  for (  AccessControlEntry entry : equivalent.keySet()) {
    AccessControlEntry eqv=equivalent.get(entry);
    assertEquals(entry.hashCode(),eqv.hashCode());
  }
}
