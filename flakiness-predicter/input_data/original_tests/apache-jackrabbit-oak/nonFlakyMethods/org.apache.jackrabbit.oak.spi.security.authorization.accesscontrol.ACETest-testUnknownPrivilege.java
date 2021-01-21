/** 
 * @since oak 1.0 ACE doesn't validate privileges.
 */
@Test public void testUnknownPrivilege() throws Exception {
  Privilege invalidPriv=new Privilege(){
    public String getName(){
      return "";
    }
    public boolean isAbstract(){
      return false;
    }
    public boolean isAggregate(){
      return false;
    }
    public Privilege[] getDeclaredAggregatePrivileges(){
      return new Privilege[0];
    }
    public Privilege[] getAggregatePrivileges(){
      return new Privilege[0];
    }
  }
;
  Privilege[] privs=new Privilege[]{invalidPriv,acMgr.privilegeFromName(PrivilegeConstants.JCR_READ)};
  ACE entry=createEntry(testPrincipal,privs,true);
  assertEquals(getBitsProvider().getBits(PrivilegeConstants.JCR_READ),entry.getPrivilegeBits());
}
