/** 
 * @see <a href="https://issues.apache.org/jira/browse/OAK-1348">OAK-1348</a>
 */
@Test public void testAddEntryWithCustomPrincipalImpl() throws Exception {
  Principal custom=new Principal(){
    public String getName(){
      return testPrincipal.getName();
    }
  }
;
  acl.addEntry(testPrincipal,testPrivileges,true);
  acl.addEntry(custom,testPrivileges,false);
  acMgr.setPolicy(acl.getPath(),acl);
  superuser.save();
}
