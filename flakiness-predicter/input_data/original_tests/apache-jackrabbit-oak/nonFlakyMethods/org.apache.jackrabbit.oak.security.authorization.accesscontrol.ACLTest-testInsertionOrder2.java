@Test public void testInsertionOrder2() throws Exception {
  Privilege[] readPriv=privilegesFromNames(JCR_READ);
  Privilege[] writePriv=privilegesFromNames(JCR_WRITE);
  Privilege[] addNodePriv=privilegesFromNames(JCR_ADD_CHILD_NODES);
  Map<String,Value> restrictions=Collections.singletonMap(REP_GLOB,getValueFactory().createValue("/.*"));
  acl.addEntry(testPrincipal,readPriv,true);
  acl.addEntry(testPrincipal,addNodePriv,true,restrictions);
  acl.addEntry(testPrincipal,writePriv,false);
  List<? extends JackrabbitAccessControlEntry> entries=acl.getEntries();
  assertACE(entries.get(0),true,readPriv);
  assertACE(entries.get(1),true,addNodePriv);
  assertACE(entries.get(2),false,writePriv);
}
