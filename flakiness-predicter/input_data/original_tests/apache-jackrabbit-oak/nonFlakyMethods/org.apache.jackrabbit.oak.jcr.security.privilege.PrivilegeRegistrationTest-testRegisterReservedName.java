@Test public void testRegisterReservedName(){
  Map<String,String[]> illegal=new HashMap<String,String[]>();
  illegal.put(null,new String[0]);
  illegal.put("jcr:privilegeName",new String[0]);
  illegal.put("rep:privilegeName",new String[0]);
  illegal.put("nt:privilegeName",new String[0]);
  illegal.put("mix:privilegeName",new String[0]);
  illegal.put("sv:privilegeName",new String[0]);
  illegal.put("xml:privilegeName",new String[0]);
  illegal.put("xmlns:privilegeName",new String[0]);
  illegal.put("newPrivilege",new String[]{"jcr:privilegeName"});
  for (  String illegalName : illegal.keySet()) {
    try {
      privilegeManager.registerPrivilege(illegalName,true,illegal.get(illegalName));
      fail("Illegal name -> Exception expected");
    }
 catch (    RepositoryException e) {
    }
  }
}
