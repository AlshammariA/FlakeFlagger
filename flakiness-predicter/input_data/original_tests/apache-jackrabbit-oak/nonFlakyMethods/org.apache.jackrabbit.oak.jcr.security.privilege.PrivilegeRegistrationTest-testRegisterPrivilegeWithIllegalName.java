@Test public void testRegisterPrivilegeWithIllegalName(){
  Map<String,String[]> illegal=new HashMap<String,String[]>();
  illegal.put(null,new String[0]);
  illegal.put("",new String[0]);
  illegal.put("invalid:privilegeName",new String[0]);
  illegal.put(".e:privilegeName",new String[0]);
  illegal.put("newPrivilege",new String[]{"invalid:privilegeName"});
  illegal.put("newPrivilege",new String[]{".e:privilegeName"});
  illegal.put("newPrivilege",new String[]{null});
  illegal.put("newPrivilege",new String[]{""});
  for (  String illegalName : illegal.keySet()) {
    try {
      privilegeManager.registerPrivilege(illegalName,true,illegal.get(illegalName));
      fail("Illegal name -> Exception expected");
    }
 catch (    NamespaceException e) {
    }
catch (    RepositoryException e) {
    }
  }
}
