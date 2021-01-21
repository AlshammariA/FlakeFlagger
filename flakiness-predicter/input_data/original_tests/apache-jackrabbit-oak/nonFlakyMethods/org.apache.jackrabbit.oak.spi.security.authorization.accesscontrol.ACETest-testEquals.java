@Test public void testEquals() throws RepositoryException {
  Map<AccessControlEntry,AccessControlEntry> equalAces=new HashMap<AccessControlEntry,AccessControlEntry>();
  ACE ace=createEntry(PrivilegeConstants.JCR_ALL);
  equalAces.put(ace,createEntry(PrivilegeConstants.JCR_ALL));
  Privilege[] declaredAllPrivs=acMgr.privilegeFromName(PrivilegeConstants.JCR_ALL).getDeclaredAggregatePrivileges();
  equalAces.put(ace,createEntry(testPrincipal,declaredAllPrivs,true));
  Privilege[] aggregateAllPrivs=acMgr.privilegeFromName(PrivilegeConstants.JCR_ALL).getAggregatePrivileges();
  equalAces.put(ace,createEntry(testPrincipal,aggregateAllPrivs,true));
  List<Privilege> reordered=new ArrayList<Privilege>(Arrays.asList(aggregateAllPrivs));
  reordered.add(reordered.remove(0));
  equalAces.put(createEntry(testPrincipal,reordered.toArray(new Privilege[reordered.size()]),true),createEntry(testPrincipal,aggregateAllPrivs,true));
  equalAces.put(createEntry(testPrincipal,declaredAllPrivs,true),createEntry(testPrincipal,aggregateAllPrivs,true));
  for (  AccessControlEntry entry : equalAces.keySet()) {
    assertEquals(entry,equalAces.get(entry));
  }
}
