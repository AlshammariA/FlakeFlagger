@Test public void testHashCode2() throws Exception {
  JackrabbitAccessControlEntry ace=createEntry(new String[]{PrivilegeConstants.JCR_ALL},true);
  final Privilege[] privs=AccessControlUtils.privilegesFromNames(acMgr,PrivilegeConstants.JCR_ALL);
  List<JackrabbitAccessControlEntry> otherAces=new ArrayList<JackrabbitAccessControlEntry>();
  Principal princ=new Principal(){
    public String getName(){
      return "a name";
    }
  }
;
  otherAces.add(createEntry(princ,privs,true));
  otherAces.add(createEntry(new String[]{PrivilegeConstants.JCR_READ},true));
  otherAces.add(createEntry(new String[]{PrivilegeConstants.JCR_ALL},false));
  otherAces.add(createEntry(new String[]{PrivilegeConstants.REP_WRITE},false));
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
    assertFalse(ace.hashCode() == otherAce.hashCode());
  }
}
