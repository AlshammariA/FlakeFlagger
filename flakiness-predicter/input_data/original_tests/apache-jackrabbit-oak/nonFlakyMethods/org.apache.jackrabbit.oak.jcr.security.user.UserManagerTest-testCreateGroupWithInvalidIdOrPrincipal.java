@Test public void testCreateGroupWithInvalidIdOrPrincipal() throws RepositoryException, NotExecutableException {
  Principal p=getTestPrincipal();
  String uid=p.getName();
  Principal emptyNamePrincipal=new PrincipalImpl("");
  Map<String,Principal> fail=new HashMap<String,Principal>();
  fail.put(uid,null);
  fail.put(uid,emptyNamePrincipal);
  fail.put(null,p);
  fail.put("",p);
  for (  String id : fail.keySet()) {
    Group g=null;
    try {
      Principal princ=fail.get(id);
      g=userMgr.createGroup(id,princ,null);
      fail("Creating group with id '" + id + "' and principal '"+ princ.getName()+ "' should fail");
    }
 catch (    IllegalArgumentException e) {
    }
 finally {
      if (g != null) {
        g.remove();
        superuser.save();
      }
    }
  }
}
