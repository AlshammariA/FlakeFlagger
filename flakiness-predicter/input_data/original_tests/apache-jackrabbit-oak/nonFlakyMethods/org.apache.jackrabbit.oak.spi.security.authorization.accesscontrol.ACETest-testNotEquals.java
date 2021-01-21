@Test public void testNotEquals() throws RepositoryException {
  ACE ace=createEntry(new String[]{PrivilegeConstants.JCR_ALL},true);
  List<JackrabbitAccessControlEntry> otherAces=new ArrayList<JackrabbitAccessControlEntry>();
  try {
    Principal princ=new Principal(){
      public String getName(){
        return "a name";
      }
    }
;
    Privilege[] privs=new Privilege[]{acMgr.privilegeFromName(PrivilegeConstants.JCR_ALL)};
    otherAces.add(createEntry(princ,privs,true));
  }
 catch (  RepositoryException e) {
  }
  try {
    otherAces.add(createEntry(new String[]{PrivilegeConstants.JCR_READ},true));
  }
 catch (  RepositoryException e) {
  }
  try {
    otherAces.add(createEntry(new String[]{PrivilegeConstants.JCR_ALL},false));
  }
 catch (  RepositoryException e) {
  }
  try {
    otherAces.add(createEntry(new String[]{PrivilegeConstants.REP_WRITE},false));
  }
 catch (  RepositoryException e) {
  }
  final Privilege[] privs=new Privilege[]{acMgr.privilegeFromName(PrivilegeConstants.JCR_ALL)};
  JackrabbitAccessControlEntry pe=new JackrabbitAccessControlEntry(){
    public boolean isAllow(){
      return true;
    }
    public String[] getRestrictionNames(){
      return new String[0];
    }
    public Value getRestriction(    String restrictionName){
      return null;
    }
    public Value[] getRestrictions(    String restrictionName){
      return null;
    }
    public Principal getPrincipal(){
      return testPrincipal;
    }
    public Privilege[] getPrivileges(){
      return privs;
    }
  }
;
  otherAces.add(pe);
  for (  JackrabbitAccessControlEntry otherAce : otherAces) {
    assertFalse(ace.equals(otherAce));
  }
}
