@Test public void testRemoveInvalidEntry() throws Exception {
  try {
    acl.removeAccessControlEntry(new JackrabbitAccessControlEntry(){
      public boolean isAllow(){
        return false;
      }
      public String[] getRestrictionNames(){
        return new String[0];
      }
      public Value getRestriction(      String restrictionName){
        return null;
      }
      public Value[] getRestrictions(      String restrictionName){
        return null;
      }
      public Principal getPrincipal(){
        return testPrincipal;
      }
      public Privilege[] getPrivileges(){
        return testPrivileges;
      }
    }
);
    fail("Passing an unknown ACE should fail");
  }
 catch (  AccessControlException e) {
  }
}
