@Test public void testInsertionOrder() throws Exception {
  Privilege[] readPriv=privilegesFromNames(JCR_READ);
  Privilege[] writePriv=privilegesFromNames(JCR_WRITE);
  Privilege[] addNodePriv=privilegesFromNames(JCR_ADD_CHILD_NODES);
  Map<String,Value> restrictions=Collections.singletonMap(REP_GLOB,getValueFactory().createValue("/.*"));
  acl.addEntry(testPrincipal,readPriv,true);
  acl.addEntry(testPrincipal,writePriv,false);
  acl.addEntry(testPrincipal,addNodePriv,true,restrictions);
  List<? extends JackrabbitAccessControlEntry> entries=acl.getEntries();
  assertACE(entries.get(0),true,readPriv);
  assertACE(entries.get(1),false,writePriv);
  assertACE(entries.get(2),true,addNodePriv);
}
