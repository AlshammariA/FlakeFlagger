@Test public void testAddEntry() throws NotExecutableException, RepositoryException {
  List<AccessControlEntry> entriesBefore=Arrays.asList(acl.getAccessControlEntries());
  if (acl.addEntry(testPrincipal,testPrivileges,true,Collections.<String,Value>emptyMap())) {
    AccessControlEntry[] entries=acl.getAccessControlEntries();
    AccessControlEntry ace=null;
    for (    AccessControlEntry entry : entries) {
      if (testPrincipal.equals(entry.getPrincipal())) {
        ace=entry;
      }
    }
    assertNotNull("addEntry was successful -> expected entry for tesPrincipal.",ace);
    assertTrue("addEntry was successful -> at least 1 entry.",entries.length > 0);
  }
 else {
    AccessControlEntry[] entries=acl.getAccessControlEntries();
    assertEquals("Grant ALL not successful -> entries must not have changed.",entriesBefore,Arrays.asList(entries));
  }
}
